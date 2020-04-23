package com.neuqmsc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/23 11:27
 * @ItemName: opcToMobile
 */
@EnableDubbo
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class H5ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(H5ServerApplication.class,args);
    }
}
