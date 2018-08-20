package com.crowdfunding;

import com.crowdfunding.mapper.UserMapper;
import com.crowdfunding.pojo.User;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdfundingApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProcessEngineFactoryBean bean;
    @Autowired
    RuntimeService runtimeService;

    @Autowired
    RepositoryService repositoryService;
    @Test
    public void contextLoads() {
       // repositoryService.createDeployment().addClasspathResource("processes/test1.bpmn").deploy();
       runtimeService.startProcessInstanceById("myProcess_1:3:35004");

    }
    @Autowired DataSource dataSource;

    @Test
    public void test(){
        System.out.println(dataSource);
    }

}
