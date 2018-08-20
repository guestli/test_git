package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Member_Project_FollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member_Project_Follow record);

    int insertSelective(Member_Project_Follow record);

    Member_Project_Follow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member_Project_Follow record);

    int updateByPrimaryKey(Member_Project_Follow record);
}