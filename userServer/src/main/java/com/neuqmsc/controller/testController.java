package com.neuqmsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/24 23:13
 * @ItemName: opcToMobile
 */
@Controller
public class testController {



    @RequestMapping("/gethello")
    public String hello(){

        return "";
    }
}
