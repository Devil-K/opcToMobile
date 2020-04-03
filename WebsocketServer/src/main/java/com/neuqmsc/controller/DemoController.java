package com.neuqmsc.controller;

import com.neuqmsc.config.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * WebSocketController
 * @author zhengkai.blog.csdn.net
 */
@Controller
public class DemoController {


    @ResponseBody
    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("---007@请求成功");
    }

    @RequestMapping("/sendMessageTo/allUser")
    public ResponseEntity<String> Test() throws Exception{
       // WebSocketServer webSocketServer = new WebSocketServer();
        String message="这是我发送给所有客户端的消息this is My Message";
        //webSocketServer.sendMessage(message);
        WebSocketServer.sendInfo(message,message);


        return ResponseEntity.ok("hhhhh");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    //http://114.116.246.6:9998/demo/push/111?message=777
    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message,
                              @PathVariable String toUserId) throws IOException {
//        message="wode的";
        WebSocketServer webSocketServer = new WebSocketServer();
        System.out.println("这是message"+message);
        webSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
       // @Scheduled(fixedRate = 10000)
    }
   // @Scheduled(fixedRate = 10000)
    public void sendTopic() throws IOException {
        String random = Math.random()+"";
        System.out.println(random+"一秒钟传输一次random");
        WebSocketServer.sendInfo(random,random);


    }
}
