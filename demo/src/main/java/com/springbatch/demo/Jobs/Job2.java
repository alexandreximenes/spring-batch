package com.springbatch.demo.Jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Job2 {

    public static final String JOB_PARAMETERS_NAME = "#{jobParameters['name']}";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job mJob(){
        return jobBuilderFactory
                .get("mJob")
                .start(imprimeOlaStep())
                .incrementer(new RunIdIncrementer()) //incrementador automatico do id job
                .build();
    }

    private Step imprimeOlaStep() {
        return stepBuilderFactory
                .get("imprimeOlaStep")
                .tasklet(myTasklet(null))
                .build();
    }

    @StepScope
    @Bean
    public Tasklet myTasklet(@Value(JOB_PARAMETERS_NAME) String name) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Ola mundo, parametro: " +name);
                return RepeatStatus.FINISHED;
            }
        };
    }
}
