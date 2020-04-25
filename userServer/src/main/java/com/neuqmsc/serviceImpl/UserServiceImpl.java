package com.neuqmsc.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.neuqmsc.entity.NeuqUsers;
import com.neuqmsc.mapper.NeuqUsersMapper;
import com.neuqmsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/24 22:38
 * @ItemName: opcToMobile
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    NeuqUsersMapper users;

    @Override
    public NeuqUsers joinIn() {
        return null;
    }

    @Override
    public List<NeuqUsers> getAllUsers() {
        return users.selectAll();
    }
}
