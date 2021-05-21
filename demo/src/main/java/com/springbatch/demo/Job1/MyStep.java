package com.springbatch.demo.Job1;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyStep {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimeOlaStep(Tasklet myTasklet) {
        return stepBuilderFactory
                .get("imprimeOlaStep")
                .tasklet(myTasklet)
                .build();
    }

}
