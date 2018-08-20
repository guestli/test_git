package com.crowdfunding.service.impl;

import com.crowdfunding.mapper.AdvertisementMapper;
import com.crowdfunding.pojo.Advertisement;
import com.crowdfunding.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    AdvertisementMapper advertisementMapper;
    @Override
    public int addAdvertisement(Advertisement advertisement) {
        return advertisementMapper.insertSelective(advertisement);
    }
}
