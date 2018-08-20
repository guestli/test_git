package com.crowdfunding.controller;

import com.crowdfunding.common.ResponseResult;
import com.crowdfunding.pojo.Role;
import com.crowdfunding.service.RoleService;
import com.crowdfunding.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/assignRole/{id}",method = RequestMethod.GET)
    public String assignRole(@PathVariable("id") Integer userId , ModelMap map){
        List<Role> roles = roleService.getRole(userId);
        List<Role> allRoles = roleService.getAllRole();
        for(Role role:roles){
            for(Role allrole:allRoles){
                if(allrole.getId()==role.getId()){
                    allRoles.remove(allrole);
                    break;
                }
            }
        }
        map.put("roles", roles);
        map.put("allRole", allRoles);
        map.put("userId", userId);
        return "assignRole";
    }

    @RequestMapping(value = "/addAssignRole",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addAssignRole(@RequestParam("userId")Integer userId, @RequestParam("roleIds[]")Integer[] roleIds){
        if(roleIds == null || roleIds.length<1){
            return null;
        }
        if(roleService.addRole4User(userId,roleIds)==roleIds.length){
            ResponseResult.success();
        }
        return ResponseResult.error("分配角色失败");

    }

    @RequestMapping(value = "/deleteAssignRole",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult deleteAssignRole(@RequestParam("userId")Integer userId, @RequestParam("roleIds[]")Integer[] roleIds){
        if(roleIds == null || roleIds.length<1){
            return null;
        }
        if(roleService.deleteRole4User(userId,roleIds)==roleIds.length){
            ResponseResult.success();
        }
        return ResponseResult.error("分配角色失败");

    }
}
