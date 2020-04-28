package com.neuqmsc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuqmsc.config.WebSocketConfig;
import com.neuqmsc.config.WebSocketServer;
import com.neuqmsc.entity.PlcDevice;
import com.neuqmsc.mapper.PlcDeviceMapper;
import com.neuqmsc.service.sendValService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;

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

    @Autowired
    sendValService sendService;

    @Scheduled(fixedRate = 2000)
    public void sendToMobile()throws Exception{
//        PlcDevice plcDevice = plcdevice.selectByPrimaryKey(".DNS2");
        List<PlcDevice> plcDevices = plcdevice.selectAll();
        JSONObject jsondevice = new JSONObject();
        for (PlcDevice device:plcDevices)
        {
            String deviceName = device.getDeviceName();
           String splitName= deviceName.substring(deviceName.indexOf(".")+1);


            int exist= plcdevice.checkTable(splitName);//判断表是否存在
            if(exist==0){
                plcdevice.creatTableByDeviceName(splitName);//创建表
            }
            String deviceValue = device.getDeviceValue().toString();
            plcdevice.saveDeviceVal(deviceValue,splitName);//存储数据
            String deviceTime = device.getDeviceTime();
            jsondevice.put(splitName,deviceValue);
            jsondevice.put("deviceTime",deviceTime);

        }
        String deviceJson = jsondevice.toJSONString();
        /*预留接口，处理数据转换问题*/
//        String jsonVal1 = sendService.dealDevice(deviceJson);


        WebSocketServer.sendInfo(deviceJson,"all");
    }


}
