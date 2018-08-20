package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Member_AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member_Address record);

    int insertSelective(Member_Address record);

    Member_Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member_Address record);

    int updateByPrimaryKey(Member_Address record);
}