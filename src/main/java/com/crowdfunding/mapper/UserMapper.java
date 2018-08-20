package com.crowdfunding.mapper;

import com.crowdfunding.common.PageResult;
import com.crowdfunding.pojo.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User select4Login(Map map);

    Integer getCount();

    List<User> getUser4Page(PageResult pageResult);
}