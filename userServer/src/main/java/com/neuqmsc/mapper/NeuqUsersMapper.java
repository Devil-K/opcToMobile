package com.neuqmsc.mapper;

import com.neuqmsc.entity.NeuqUsers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NeuqUsersMapper {
//    int deleteByPrimaryKey(Integer userId);
//
//    int insert(NeuqUsers record);

    NeuqUsers selectByPrimaryKey(Integer userId);

    List<NeuqUsers> selectAll();

    int updateByPrimaryKey(NeuqUsers record);
}