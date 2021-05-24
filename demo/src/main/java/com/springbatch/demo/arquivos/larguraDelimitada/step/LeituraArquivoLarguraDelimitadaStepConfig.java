package com.springbatch.demo.arquivos.larguraDelimitada.step;

import com.springbatch.demo.arquivos.larguraDelimitada.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LeituraArquivoLarguraDelimitadaStepConfig {

	@Bean
	public Step leituraArquivoLarguraDelimitadaStep(@Autowired StepBuilderFactory stepBuilderFactory,
											  ItemReader<Cliente> leituraArquivoLarguraDelimitadaReader,
											  ItemWriter<Cliente> leituraArquivoLarguraDelimitadaWriter) {
		return stepBuilderFactory
				.get("leituraArquivoLarguraDelimitadaStep")
				.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoLarguraDelimitadaReader)
				.writer(leituraArquivoLarguraDelimitadaWriter)
				.build();
	}
}
