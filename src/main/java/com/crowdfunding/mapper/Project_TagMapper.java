package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Project_TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project_Tag record);

    int insertSelective(Project_Tag record);

    Project_Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project_Tag record);

    int updateByPrimaryKey(Project_Tag record);
}