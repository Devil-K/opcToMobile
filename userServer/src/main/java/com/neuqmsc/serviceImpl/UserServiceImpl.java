package com.neuqmsc.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuqmsc.entity.NeuqUsers;
import com.neuqmsc.entity.userLevel;
import com.neuqmsc.mapper.NeuqUsersMapper;
import com.neuqmsc.mapper.userLevelMapper;
import com.neuqmsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    NeuqUsersMapper users;

    @Autowired
    userLevelMapper userlevel;


    @Override
    public NeuqUsers dologin(String useraccount, String userpassword) {
        NeuqUsers  user= users.doLogin(useraccount,userpassword);
        return user;
    }

    @Override
    public NeuqUsers changeselfByAccount(String useraccount) {
        NeuqUsers user=users.checkAccount(useraccount);
        return user;
    }

    @Override
    public int updateInfoByself(NeuqUsers neuqUsers) {
        int uid=users.updateBySelf(neuqUsers);
        return uid;
    }

    @Override
    public void register(NeuqUsers neuqusers) {

    }

    @Override
    public NeuqUsers checkUserexist(String useraccount) {
       NeuqUsers user= users.checkUserExist(useraccount);
        return user;
    }

    @Override //用户注册到数据库
    public int addUser(NeuqUsers neuqUsers) {
        int res = users.insert(neuqUsers);
        return res;
    }

    @Override //得到所有员工信息
    public PageInfo<NeuqUsers> getAllUsers(Integer pn) {
        //每页记录数
        PageHelper.startPage(pn, 3);
        List<NeuqUsers> neuqUsers = users.selectAll();
        return new PageInfo<NeuqUsers>(neuqUsers);
    }

    @Override //修改前 查询所有职级信息
    public List<userLevel> getUserLevel() {
        List<userLevel> userLevels = userlevel.selectAll();
        return userLevels;
    }

    @Override //修改前 查询信息
    public NeuqUsers getUserByid(Integer userId) {
        NeuqUsers userinfo = users.selectByPrimaryKey(userId);
        return userinfo;
    }

    @Override
    public int commitChangeInfo(NeuqUsers neuqUser) {
        int uid = users.updateByManager(neuqUser);
        return uid;
    }

    @Override
    public int deleteById(Integer user_id) {
        int rid = users.deleteByuserId(user_id);
        return rid;
    }

    @Override //申请列表
    public PageInfo<NeuqUsers> getApplyList(Integer pn) {
        //每页记录数
        PageHelper.startPage(pn, 3);
        List<NeuqUsers> neuqUsers = users.selectApplyList();
        return new PageInfo<NeuqUsers>(neuqUsers);
    }

    @Override
    public int agreeApply(Integer userId) {
        int uid = users.agreeApply(userId);
        return uid;
    }

    @Override
    public int disagreeApply(Integer userId) {
        int uid = users.disagreeApply(userId);
        return uid;
    }


    @Override
    public String ManageChageuser(NeuqUsers neuqusers) {
        return null;
    }

    @Override
    public void deleteUser() {

    }


}
