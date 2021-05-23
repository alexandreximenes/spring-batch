package com.springbatch.demo.arquivos.larguraFixa.step;

import com.springbatch.demo.arquivos.larguraFixa.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

	@Bean
	public Step leituraArquivoLarguraFixaStep(@Autowired StepBuilderFactory stepBuilderFactory,
											  ItemReader<Cliente> leituraArquivoLarguraFixaReader,
											  ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
		return stepBuilderFactory
				.get("leituraArquivoLarguraFixaStep")
				.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}
}
