package com.neuqmsc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuqmsc.entity.NeuqUsers;
import com.neuqmsc.mapper.NeuqUsersMapper;
import com.neuqmsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/24 23:13
 * @ItemName: opcToMobile
 */
@Controller
public class testController {

    @Autowired
    NeuqUsersMapper users;


    @ResponseBody
    @RequestMapping("/gethello")
    public String hello(){
        PageHelper.startPage(1,4);
        List<NeuqUsers> neuqUsers = users.selectAll();
        PageInfo<NeuqUsers> allUsers = new PageInfo<>(neuqUsers);
        System.out.println();
        System.out.println("当前页面" + allUsers.getPageNum());
        System.out.println("总页码" + allUsers.getPages());
        System.out.println("总记录数" + allUsers.getTotal());
        System.out.println("当前页有几个记录" + allUsers.getSize());
        System.out.println("当前页的pagesize" + allUsers.getPageSize());
        System.out.println("前一页" + allUsers.getPrePage());
        System.out.println("结果" + allUsers.getList());
        return allUsers.toString();
    }

    @ResponseBody
    @RequestMapping("/getall")
    public String getAll(){
        List<NeuqUsers> neuqUsers = users.selectAll();
        return neuqUsers.toString();
    }
}
