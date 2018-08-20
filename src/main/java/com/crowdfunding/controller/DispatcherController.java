package com.crowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {

    @RequestMapping("/advertisement")
    public String goAdvertisement(){
        return "advertisement";
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
}
