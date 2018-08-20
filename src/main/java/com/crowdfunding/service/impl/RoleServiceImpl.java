package com.crowdfunding.service.impl;

import com.crowdfunding.mapper.RoleMapper;
import com.crowdfunding.mapper.User_RoleMapper;
import com.crowdfunding.pojo.Role;
import com.crowdfunding.pojo.User_Role;
import com.crowdfunding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    User_RoleMapper userRoleMapper;
    @Override
    public List<Role> getAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public List<Role> getRole(Integer userId) {
        return userRoleMapper.selectRoleByUserId(userId);
    }

    @Override
    public int addRole4User(Integer userId,Integer[] roleIds) {
        return userRoleMapper.insertBatch(userId,roleIds);
    }

    @Override
    public int deleteRole4User(Integer userId,Integer[] roleIds) {
        return userRoleMapper.deletetBatch(userId,roleIds);
    }
}
