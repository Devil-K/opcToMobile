package com.neuqmsc.mapper;

import com.neuqmsc.entity.NeuqUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NeuqUsersMapper {
    NeuqUsers doLogin(@Param(value = "useraccount") String useraccount, @Param(value = "userpassword")String userpassword);
    NeuqUsers checkAccount(String useraccount);
    int updateBySelf(NeuqUsers neuqUsers);

    int deleteByPrimaryKey(Integer userId);

    int insert(NeuqUsers record);
    NeuqUsers checkUserExist(String useraccount);

    NeuqUsers selectByPrimaryKey(Integer userId);

    List<NeuqUsers> selectAll();
    int deleteByuserId(Integer userId);

    List<NeuqUsers> selectApplyList();

    int updateByPrimaryKey(NeuqUsers record);
    int updateByManager(NeuqUsers neuqUser);
    int disagreeApply(Integer userId);
    int agreeApply(Integer userId);
}