package com.crowdfunding.service.impl;

import com.crowdfunding.mapper.PermissionMapper;
import com.crowdfunding.pojo.Permission;
import com.crowdfunding.service.PermissionService;
import com.crowdfunding.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public PermissionVO getAllPermission() {
        List<PermissionVO> PermissionVOs = permissionMapper.selectAllPermission();
        Map<Integer,PermissionVO> map = new HashMap<>();
        for(PermissionVO permissionVO:PermissionVOs){
            map.put(permissionVO.getId() ,permissionVO );
        }
        PermissionVO root = null;
        for(PermissionVO children:PermissionVOs){
            if(children.getPid() == 0){
                root = children;
            }else{
                PermissionVO parent = map.get(children.getPid());
                List<PermissionVO> childrens = parent.getChildren();
                childrens.add(children);
            }
        }
        return root;
    }
}
