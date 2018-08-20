package com.crowdfunding.controller;

import com.crowdfunding.common.Const;
import com.crowdfunding.common.ResponseResult;
import com.crowdfunding.pojo.Advertisement;
import com.crowdfunding.pojo.User;
import com.crowdfunding.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    @ResponseBody
    @RequestMapping(value = "/addAdvertisement",method = RequestMethod.POST)
    public ResponseResult addAdvertisement(Advertisement advertisement, @RequestParam("file") MultipartFile file, HttpSession session){
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.indexOf(".") );
        fileName = UUID.randomUUID().toString()+extName;
        advertisement.setName(fileName);
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        advertisement.setUserid(user.getId());
        advertisement.setStatus("1");
        int count = advertisementService.addAdvertisement(advertisement);
        return ResponseResult.success();

    }
}
