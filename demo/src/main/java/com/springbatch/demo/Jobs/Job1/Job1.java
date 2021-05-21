package com.springbatch.demo.Jobs.Job1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
public class Job1 {

    String jobName = this.getClass().getName().concat("job");
    public static final String JOB_PARAMETERS_NAME = "#{jobParameters['name']}";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job mJob2(Step imprimeOlaStep){

        return jobBuilderFactory
                .get(jobName)
                .start(imprimeOlaStep)
                .incrementer(new RunIdIncrementer()) //incrementador automatico do id job
                .build();
    }
}
