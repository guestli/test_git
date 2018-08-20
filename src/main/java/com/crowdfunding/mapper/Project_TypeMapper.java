package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Project_TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project_Type record);

    int insertSelective(Project_Type record);

    Project_Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project_Type record);

    int updateByPrimaryKey(Project_Type record);
}