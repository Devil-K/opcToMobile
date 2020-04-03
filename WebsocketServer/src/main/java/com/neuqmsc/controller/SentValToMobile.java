package com.neuqmsc.controller;

import com.neuqmsc.config.WebSocketConfig;
import com.neuqmsc.config.WebSocketServer;
import com.neuqmsc.entity.PlcDevice;
import com.neuqmsc.mapper.PlcDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/3 18:48
 * @ItemName: opcToMobile
 */
@Controller
public class SentValToMobile {

    @Autowired
    PlcDeviceMapper plcdevice;

    @Scheduled(fixedRate = 1000)
    public void sendToMobile()throws Exception{
        PlcDevice plcDevice = plcdevice.selectByPrimaryKey(".DNS2");
        String value = plcDevice.getDeviceValue().toString();
        WebSocketServer.sendInfo(value,"all");
    }


}
