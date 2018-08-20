package com.crowdfunding.controller;

import com.crowdfunding.common.PageResult;
import com.crowdfunding.common.ResponseResult;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ActivitiController {

    @Autowired
    RepositoryService repositoryService;

    @RequestMapping("/process/process")
    public String process(){
        return "process";
    }

    @RequestMapping("/process/img")
    @ResponseBody
    public void img(@RequestParam("id")String id, HttpServletResponse response) throws IOException {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();
        InputStream processDiagram = repositoryService.getProcessDiagram(id);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(processDiagram, outputStream);
    }

    @RequestMapping("/process/showPic")
    public String showPic(){
        return "showPic";
    }

    @ResponseBody
    @RequestMapping(value = "/process/deleteProcess/{id}",method = RequestMethod.DELETE)
    public ResponseResult dedeleteProcess(@PathVariable("id") String id){
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(id).singleResult();
            repositoryService.deleteDeployment(processDefinition.getDeploymentId());
            return ResponseResult.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("删除失败");
        }
    }

    @ResponseBody
    @RequestMapping("/process/deploy")
    public ResponseResult deploy(@RequestParam("file")MultipartFile file){
        try {
            repositoryService.createDeployment().addInputStream(file.getOriginalFilename(), file.getInputStream()).deploy();
            return ResponseResult.success("部署成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.error("部署失败");
        }
    }

    @ResponseBody
    @RequestMapping("/process/doProcess")
    public PageResult doProcess(@RequestParam(value = "pageNo",required = false,defaultValue = "1")Integer pageNo,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize){
        PageResult pageResult = new PageResult(pageSize,pageNo);
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery().orderByDeploymentId().desc();
        Long count = query.count();
        pageResult.setResultNum(count.intValue());
        List<ProcessDefinition> processDefinitions = query.listPage(pageResult.getStartIndex(), pageSize);
        List<HashMap<String,Object>> datas = new ArrayList<>();
        for (ProcessDefinition processDefinition:processDefinitions){
            HashMap<String,Object> hashMap = new HashMap();
            hashMap.put("id", processDefinition.getId());
            hashMap.put("name", processDefinition.getName());
            hashMap.put("version", processDefinition.getVersion());
            hashMap.put("key", processDefinition.getKey());
            datas.add(hashMap);
        }
        pageResult.setDatas(datas);
        return pageResult;
    }
}
