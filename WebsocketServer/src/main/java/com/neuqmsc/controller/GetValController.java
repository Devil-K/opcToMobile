package com.neuqmsc.controller;

import com.neuqmsc.entity.PlcDevice;
import com.neuqmsc.mapper.PlcDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/2 21:55
 * @ItemName: opcToMobile
 */
@Controller
//@EnableAutoConfiguration
public class GetValController {
@Autowired
PlcDeviceMapper plcdevice;


    @ResponseBody
    @RequestMapping("/gethello")
    public PlcDevice getVV(){
        PlcDevice plcDevice = plcdevice.selectByPrimaryKey(".DNS2");

        return plcDevice;
    }


    @RequestMapping("/hello")
    public String getHello(){
        System.out.print("hello");
        new ModelAndView("websocket");
        return  "websocket";
    }
}
