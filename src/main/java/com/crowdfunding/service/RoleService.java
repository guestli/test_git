package com.crowdfunding.service;

import com.crowdfunding.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();

    List<Role> getRole(Integer userId);

    int addRole4User(Integer userId,Integer[] roleIds);

    int deleteRole4User(Integer userId,Integer[] roleIds);
}
