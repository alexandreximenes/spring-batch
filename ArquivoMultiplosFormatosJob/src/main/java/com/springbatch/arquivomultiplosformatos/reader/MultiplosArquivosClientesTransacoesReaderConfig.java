package com.springbatch.arquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultiplosArquivosClientesTransacoesReaderConfig {

	@StepScope
	@Bean
	public MultiResourceItemReader multiplosArquivosClienteTransacaoItemReader(
			@Value("#{jobParameters['arquivosClientes']}") Resource[]  resources,
			FlatFileItemReader leituraArquivoMultiplosFormatosReader){

		return new MultiResourceItemReaderBuilder<>()
				.name("multiplosArquivosClienteTransacaoItemReader")
				.resources(resources)
				.delegate(new ArquivoClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
				.build();
	}

}
