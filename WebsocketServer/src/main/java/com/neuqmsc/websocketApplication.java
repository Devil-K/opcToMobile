package com.neuqmsc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
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
//@MapperScan("com.neuqmsc.mapper")
public class websocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(websocketApplication.class,args);
    }
}
