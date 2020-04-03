package com.neuqmsc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuqmsc.entity.PlcDevice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/3 21:49
 * @ItemName: opcToMobile
 */
@Service
@Component
public class sendValService {



    public String dealDevice(String deviceJson)throws Exception{
        JSONObject jsondevice = new JSONObject();
       /* for (PlcDevice device:deviceList)
        {
            String deviceName = device.getDeviceName();
            String deviceValue = device.getDeviceValue().toString();
            jsondevice.put(deviceName,deviceValue);

        }*/
        JSONObject jsonObject = JSONObject.parseObject(deviceJson);
        Object o =jsonObject.get(".DNS2");
        Float i = Float.parseFloat(String.valueOf(o));

        String s = jsondevice.toJSONString();
        return s;
    }
}
