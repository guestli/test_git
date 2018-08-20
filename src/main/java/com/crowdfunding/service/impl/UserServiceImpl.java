package com.crowdfunding.service.impl;

import com.crowdfunding.common.PageResult;
import com.crowdfunding.mapper.UserMapper;
import com.crowdfunding.pojo.User;
import com.crowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User select4Login(Map map) {
        User user = userMapper.select4Login(map);
        return user;
    }

    @Override
    public PageResult getUser4Page(PageResult pageResult) {
        Integer resultNum = userMapper.getCount();
        pageResult.setResultNum(resultNum);
        List<User> users = userMapper.getUser4Page(pageResult);
        pageResult.setDatas(users);
        return pageResult;
    }

}
