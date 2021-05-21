package com.springbatch.demo.Job1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Job1 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job mJob(Step imprimeOlaStep){
        return jobBuilderFactory
                .get("mJob")
                .start(imprimeOlaStep)
                .build();
    }
}
