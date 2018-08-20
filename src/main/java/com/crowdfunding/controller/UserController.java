package com.crowdfunding.controller;

import com.crowdfunding.common.Const;
import com.crowdfunding.common.PageResult;
import com.crowdfunding.common.ResponseResult;
import com.crowdfunding.pojo.User;
import com.crowdfunding.service.RoleService;
import com.crowdfunding.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("go_login")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "do_login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doLogin(@RequestParam("loginacct")String loginacct, @RequestParam("userpswd")String userpswd, HttpSession session){
        Map map = new HashMap();
        map.put("loginacct", loginacct);
        map.put("userpswd", userpswd);
        User user = userService.select4Login(map);

        if(user!=null){
            session.setAttribute(Const.CURRENT_USER, user);
            user.setUserpswd(null);
            return ResponseResult.success("success");
        }
        return ResponseResult.error("error");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/user/userPage",method = RequestMethod.GET)
    @ResponseBody
    public PageResult getUser(@RequestParam(value = "pageNo",required = false,defaultValue = "1")Integer pageNo,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize,
                              @RequestParam(value = "queryText",required = false)String queryText){
        if(!StringUtils.isEmpty(queryText)){
            queryText = queryText.replace(" ", "");
            if(queryText.contains("%")){
                queryText = queryText.replace("%", "\\%");
            }
        }
        PageResult pageResult = new PageResult();
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setQueryTest(queryText);
        pageResult = userService.getUser4Page(pageResult);
        return pageResult;
    }

    @RequestMapping("/user/user")
    public String user(){
        return "user";
    }





}
