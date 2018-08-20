package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Member_CertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member_Cert record);

    int insertSelective(Member_Cert record);

    Member_Cert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member_Cert record);

    int updateByPrimaryKey(Member_Cert record);
}