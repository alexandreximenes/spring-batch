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
    public DataSource springDataSouce(){
        return DataSourceBuilder.create().build();
    }

    @Qualifier(value = "appDataSouce")
    @ConfigurationProperties(prefix = "app.datasource")
    @Bean
    public DataSource appDataSouce(){
        return DataSourceBuilder.create().build();
    }
}
