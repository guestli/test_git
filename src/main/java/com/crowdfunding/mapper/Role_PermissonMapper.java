package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Role_PermissonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role_Permisson record);

    int insertSelective(Role_Permisson record);

    Role_Permisson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role_Permisson record);

    int updateByPrimaryKey(Role_Permisson record);
}