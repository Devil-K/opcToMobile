package com.neuqmsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/26 23:49
 * @ItemName: opcToMobile
 */
//@Controller
public class sendMessageController {

//    @Autowired
//    private JavaMailSender javaMailSender;
//
//
//    @ResponseBody
//    @RequestMapping("/sendMessage")
//    public void sendMess() {
////        创建媒体消息
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom("1771947201@qq.com");//发送人
//            helper.setTo("\n" +
//                    "59968873@qq.com");//接收人
//            helper.setSubject("注册邮件");//标题
//            helper.setText("请输入验证码9367", true);//发送的内容
//            javaMailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            e.pintStackTrace();
//        }
//    }

}



