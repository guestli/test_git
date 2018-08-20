package com.crowdfunding.config;


//import org.activiti.spring.SpringProcessEngineConfiguration;

import org.activiti.explorer.form.MonthFormType;
import org.activiti.explorer.form.ProcessDefinitionFormType;
import org.activiti.explorer.form.UserFormType;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration {

    //注入数据源和事务管理器
    @Bean
    public SpringProcessEngineConfiguration engineConfiguration(
             DataSource dataSource,
             PlatformTransactionManager transactionManager) throws IOException {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setTransactionManager(transactionManager);
        configuration.setDatabaseSchemaUpdate("true");
        configuration.setJobExecutorActivate(true);
        configuration.setActivityFontName("宋体");
        configuration.setLabelFontName("宋体");
        configuration.setCustomFormTypes(Arrays.asList(new UserFormType(),new MonthFormType(),new ProcessDefinitionFormType()));
        return configuration;
    }
}
