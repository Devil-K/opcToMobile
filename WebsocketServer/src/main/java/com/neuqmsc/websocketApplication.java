package com.neuqmsc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.neuqmsc.sendMegService.MyThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/1 23:11
 * @ItemName: plcToAndroid
 */
//(exclude={DataSourceAutoConfiguration.class})
@EnableDubbo
@SpringBootApplication
@EnableScheduling
public class websocketApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(websocketApplication.class, args);

        /*for (int i=0;i<10;i++) {
            sleep(1000);
            MyThread myThread = new MyThread();
            Thread thread = new Thread(myThread);
            thread.start();
        }*/
    }
}
