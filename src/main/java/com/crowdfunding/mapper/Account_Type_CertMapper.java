package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;

public interface Account_Type_CertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account_Type_Cert record);

    int insertSelective(Account_Type_Cert record);

    Account_Type_Cert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account_Type_Cert record);

    int updateByPrimaryKey(Account_Type_Cert record);
}