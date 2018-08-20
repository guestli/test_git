package com.crowdfunding.controller;

import com.crowdfunding.pojo.Permission;
import com.crowdfunding.service.PermissionService;
import com.crowdfunding.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/permission")
    public String permission(){
        return "permission";
    }

    @RequestMapping("/getAllPermission")
    @ResponseBody
    public PermissionVO getAllPermission(){
        return permissionService.getAllPermission();
    }
}
