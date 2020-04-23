package com.neuqmsc.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.neuqmsc.bean.Neuqusers;
import com.neuqmsc.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/23 00:16
 * @ItemName: opcToMobile
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String  getAllUsers() {

        return "这是生产者的UserServiceImpl";
    }
}
