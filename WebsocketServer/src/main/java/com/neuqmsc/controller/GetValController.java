package com.neuqmsc.controller;

import com.neuqmsc.entity.PlcDevice;
import com.neuqmsc.mapper.PlcDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/2 21:55
 * @ItemName: opcToMobile
 */
@RestController
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

    @ResponseBody
    @RequestMapping("/hello")
    public String getHello(){
        System.out.print("hello");
        return "hello Test";
    }
}
