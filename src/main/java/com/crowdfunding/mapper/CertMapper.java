package com.crowdfunding.mapper;

import com.crowdfunding.pojo.*;
public interface CertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cert record);

    int insertSelective(Cert record);

    Cert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cert record);

    int updateByPrimaryKey(Cert record);
}