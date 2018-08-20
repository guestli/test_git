package com.crowdfunding.service;

import com.crowdfunding.common.PageResult;
import com.crowdfunding.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User select4Login(Map map);

    PageResult getUser4Page(PageResult pageResult);

}
