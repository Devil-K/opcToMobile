package com.neuqmsc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/2 23:12
 * @ItemName: opcToMobile
 */
@RestController
public class myController {

    @RequestMapping("/gethello")
    public String getVall(){

        System.out.print("hleeoeo");
        return "wode shijie ";
    }
}
