package com.neuqmsc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.neuqmsc.pojo.NeuqUsers;
import com.neuqmsc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/23 11:28
 * @ItemName: opcToMobile
 */
@Controller
public class UserController {

    @Reference
    UserService userservice;

    @ResponseBody
    @RequestMapping("/gethello")
    public String getList(){
        List<NeuqUsers> allUsers = userservice.getAllUsers();
        return allUsers.toString();
    }
}
