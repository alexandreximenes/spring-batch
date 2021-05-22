package com.springbatch.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource springDataSource(){
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "app.datasource")
    @Bean
    public DataSource appDataSource(){
        return DataSourceBuilder.create().build();
    }
}
