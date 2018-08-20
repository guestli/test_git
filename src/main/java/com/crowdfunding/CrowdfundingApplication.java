package com.crowdfunding;

import org.activiti.spring.boot.EndpointAutoConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = {"com.crowdfunding.controller","com.crowdfunding.config","com.crowdfunding.service"})
@MapperScan(basePackages = "com.crowdfunding.mapper")
public class CrowdfundingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdfundingApplication.class, args);
    }
}

