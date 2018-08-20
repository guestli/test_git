package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;
import com.crowdfunding.vo.PermissionVO;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<PermissionVO> selectAllPermission();
}