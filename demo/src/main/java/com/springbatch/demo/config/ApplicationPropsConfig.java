package com.springbatch.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ApplicationPropsConfig {

    public static final String PATH_APPLICATION_YML = "/home/alexandre/Documentos/cursos/application.yml";

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        System.out.println("Buscando Application.yml em "+ PATH_APPLICATION_YML);
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource(PATH_APPLICATION_YML));
        return configurer;
    }
}
