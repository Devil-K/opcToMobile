package com.neuqmsc.sendMegService;

import com.neuqmsc.config.WebSocketServer;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/3 11:50
 * @ItemName: opcToMobile
 */
public class MyThread implements  Runnable {
    @Override
    public void run() {
        WebSocketServer webSocketServer = new WebSocketServer();
        try {
            double random = Math.random();
            String a=random+"";
            webSocketServer.sendInfo(a+"骚克特","骚客");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
