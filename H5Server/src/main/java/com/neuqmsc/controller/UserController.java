package com.neuqmsc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.neuqmsc.entity.NeuqUsers;
import com.neuqmsc.entity.userLevel;
import com.neuqmsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;


@Controller
public class UserController {

    @Reference
    UserService userservice;

    @Autowired
    private JavaMailSender javaMailSender;


    int yzm;
    boolean existUser;

    @RequestMapping("/toregister")//去注册界面先查询好职级
    public String userRegister(Model model) {
        yzm = (int) (Math.random() * 9000) + 1000;
        NeuqUsers neuqUsers = new NeuqUsers();
        model.addAttribute("neuqUsers", neuqUsers);
        List<userLevel> userLevel = userservice.getUserLevel();
        model.addAttribute("userLevel", userLevel);
        return "regist";
    }

    @ResponseBody
    @GetMapping("/sendMessage")
    public void sendMess(@RequestParam("phone") String phone) {
        System.out.println("点击了发送邮件" + phone);
        NeuqUsers users = userservice.checkUserexist(phone);
        if (users == null) {
            existUser = false;
        } else {
            existUser = true;
        }
//        创建媒体消息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("1771947201@qq.com");//发送人
            helper.setTo("\n" +
                    phone);//接收人
            helper.setSubject("注册邮件申请");//标题
            helper.setText("请输入您的随机验证码：" + yzm, true);//发送的内容
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/applyToRegist")
    public String applyRegister(@ModelAttribute NeuqUsers neuqUser) {
        System.out.println("注册信息验证码" + neuqUser.getYzm());
        if (neuqUser.getYzm() == "") {
            return "fail";
        }
        Integer sendyzm = Integer.valueOf(neuqUser.getYzm());
        if (!existUser && yzm == sendyzm) {
            int resu = userservice.addUser(neuqUser);
            return "success";
        } else {
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping("/dologin")
    public String doLogin(@RequestParam("useraccount") String useraccount, @RequestParam("userpassword") String userpassword) {
        NeuqUsers dologin = userservice.dologin(useraccount, userpassword);
        if (dologin == null) {
            return "login fail";
        } else {
            String code = dologin.getUserLevel() + "" + dologin.getPeopleManage() + "";
            switch (code) {
                case "11":
                    return "login successfully!11";
                case "12":
                    return "login successfully!12";
                case "21":
                    return "login successfully!21";
                case "22":
                    return "login successfully!22";

            }
            return "login successfully!null";
        }
    }

    @RequestMapping("/toUserChangeByself")
    public String toUserChangeByself(Model model) {
        yzm = (int) (Math.random() * 9000) + 1000;
        NeuqUsers neuqUsers = new NeuqUsers();
        model.addAttribute("neuqUsers", neuqUsers);
        return "changeUserinfoAccountCheck";
    }

    @RequestMapping("/userchangebyself_account")
    public String userchangebyself(@ModelAttribute NeuqUsers neuqUsers, Model model) {
        String userAccount = neuqUsers.getUserAccount();
        String selfyzm = neuqUsers.getYzm();
        System.out.println("yzm是：" + yzm + "用户输入是：" + selfyzm);
        if (neuqUsers.getYzm() == "") {
            return "selfChangefail";

        }
        int yzm1 = Integer.valueOf(neuqUsers.getYzm());

        if(yzm!=yzm1){
            return "selfChangefail";
        }
        NeuqUsers neuqUsers1 = userservice.changeselfByAccount(userAccount);
        if (neuqUsers1 == null) {
            return "selfChangefail";

        } else {
            model.addAttribute("userInfo", neuqUsers1);
            return "userChangeInfo";
        }


    }

    @RequestMapping("/commitChangeByselfInfo")
    public String commitChangeByself(@ModelAttribute NeuqUsers neuqUsers) {
        String s = neuqUsers.toString();
        int i = userservice.updateInfoByself(neuqUsers);

        return "selfChangeSuccess";
    }

    @RequestMapping("/commitApplyChange")
    public String commitApplyChange(@ModelAttribute NeuqUsers neuqUsers) {
        int uid = userservice.updateInfoByself(neuqUsers);
        return "success";
    }


    @RequestMapping("/showAllusers")
    public String getList(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        final PageInfo<NeuqUsers> allUsers = userservice.getAllUsers(pn);
        model.addAttribute("allUserList", allUsers);
        return "userlist";
    }

    @RequestMapping("/changeUser")
    public String changeUser(@RequestParam(value = "user_id") Integer user_id, Model model) {
        List<userLevel> userLevel = userservice.getUserLevel();
        model.addAttribute("userLevel", userLevel);
        NeuqUsers userInfo = userservice.getUserByid(user_id);
        model.addAttribute("userInfo", userInfo);
        System.out.println(userInfo.getUserLevel() + "---" + userInfo.getLevelName() + "修改的id");
        return "changeuser";
    }

    @RequestMapping("/commitChange")
    public String changeUser(@ModelAttribute NeuqUsers neuqUser, Model model) {
        int rid = userservice.commitChangeInfo(neuqUser);
        System.out.println(neuqUser.toString());
//        return neuqUser.toString();
        return "redirect:showAllusers";
    }


    @RequestMapping("/deleteUser")
    public String deleteUserById(@RequestParam(value = "user_id") Integer user_id, Model model) {
        System.out.println(user_id + "删除的id");
        int a = userservice.deleteById(user_id);
        return "redirect:showAllusers";
    }

    @RequestMapping("/showApplyList")
    public String getApplylist(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageInfo<NeuqUsers> applyList = userservice.getApplyList(pn);
        model.addAttribute("allUserList", applyList);
        return "applylist";
    }

    @RequestMapping("/agreeApply")
    public String agreeApply(@RequestParam(value = "userId") Integer userId) {
        System.out.print(userId + "同意的id");

        int uid = userservice.agreeApply(userId);

        return "redirect:showApplyList";
    }

    @RequestMapping("/disagreeApply")
    public String disagreeApply(@RequestParam(value = "userId") Integer userId) {
        System.out.print(userId + "不同意的id");
        int uid = userservice.disagreeApply(userId);
        return "redirect:showApplyList";
    }
}
