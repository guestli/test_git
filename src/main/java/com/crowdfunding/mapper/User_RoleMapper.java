package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User_RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User_Role record);

    int insertSelective(User_Role record);

    User_Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_Role record);

    int updateByPrimaryKey(User_Role record);

    List<Role> selectRoleByUserId(Integer userId);

    int insertBatch(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);

    int deletetBatch(@Param("userId")Integer userId, @Param("roleIds")Integer[] roleIds);
}