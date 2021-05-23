package com.springbatch.demo.arquivos.larguraDelimitada.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraDelimitadaJobConfig {

	@Bean
	public Job arquivoLarguraDelimitadaJob(@Autowired JobBuilderFactory jobBuilderFactory, Step leituraArquivoLarguraDelimitadaStep) {
		return jobBuilderFactory
				.get("arquivoLarguraDelimitadaJob")
				.start(leituraArquivoLarguraDelimitadaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
