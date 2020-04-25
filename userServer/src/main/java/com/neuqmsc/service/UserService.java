package com.neuqmsc.service;


import com.neuqmsc.entity.NeuqUsers;
import com.neuqmsc.entity.NeuqUsers;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/23 11:29
 * @ItemName: opcToMobile
 */

public interface UserService {
    public NeuqUsers joinIn();
    public List<NeuqUsers> getAllUsers();
}
