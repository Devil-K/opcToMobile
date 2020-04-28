package com.neuqmsc.service;


import com.github.pagehelper.PageInfo;
import com.neuqmsc.entity.NeuqUsers;
import com.neuqmsc.entity.userLevel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Auther: jkMa
 * @Date: 2020/4/23 11:29
 * @ItemName: opcToMobile
 */

public interface UserService {
    NeuqUsers dologin(String useraccount, String userpassword);
    NeuqUsers changeselfByAccount(String useraccount);
    int updateInfoByself(NeuqUsers neuqUsers);

    PageInfo<NeuqUsers> getAllUsers(Integer pn);

    List<userLevel> getUserLevel(); //查询职级信息

    int deleteById(Integer userId);//根据id 删除用户（状态）

    void register(NeuqUsers neuqusers);

    NeuqUsers checkUserexist(String useraccount);

    String ManageChageuser(NeuqUsers neuqusers);

    void deleteUser();

    PageInfo<NeuqUsers> getApplyList(Integer pn);

    int addUser(NeuqUsers neuqUsers);

    NeuqUsers getUserByid(Integer userId);

    int commitChangeInfo(NeuqUsers neuqUser);

    int agreeApply(Integer userId);

    int disagreeApply(Integer userId);

}
