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
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;

@Configuration
public class Job3 {

    String jobName = this.getClass().getName().concat("job");

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job mJob3(){
        return jobBuilderFactory
                .get(jobName)
                .start(imprimeOlaStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    private Step imprimeOlaStep() {
        return stepBuilderFactory
                .get("imprimeNumerosParImparStep")
                .<Integer, String> chunk(1) //2 //3 //afata diretamente a memoria
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    private ItemWriter<? super String> writer() {
        System.out.println("WRITER >>");
        return item -> System.out.println(item);
    }

    private FunctionItemProcessor<Integer, String> processor() {
        System.out.println("READER >> List.of(0,1,2,3,4,5,6,7,8,9,10).iterator()" );
        return new FunctionItemProcessor<Integer, String>(item -> item % 2 == 0 ? String.format("Numero (%s) é PAR", item) : String.format("Numero (%s) é IMPAR", item));
    }

    private IteratorItemReader<Integer> reader() {
        System.out.println("READER >> List.of(0,1,2,3,4,5,6,7,8,9,10).iterator()" );
        return new IteratorItemReader<>(List.of(0,1,2,3,4,5,6,7,8,9,10).iterator());
    }
}
