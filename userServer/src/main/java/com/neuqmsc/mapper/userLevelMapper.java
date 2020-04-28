package com.neuqmsc.mapper;

import com.neuqmsc.entity.userLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface userLevelMapper {
    int deleteByPrimaryKey(Integer levelId);

    int insert(userLevel record);

    userLevel selectByPrimaryKey(Integer levelId);

    List<userLevel> selectAll();

    int updateByPrimaryKey(userLevel record);
}