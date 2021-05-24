package com.springbatch.demo.arquivos.larguraDelimitada.reader;

import com.springbatch.demo.arquivos.larguraDelimitada.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

//@Configuration
public class LeituraArquivoLarguraDelimitadaReaderConfig {

	//arquivoClientes=file:files/clientes.txt
	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoLarguraDelimitadaReader(@Value("#{jobParameters['arquivoClientes']}") Resource resource) {

		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoLarguraDelimitadaReader")
				.resource(resource)
				.delimited()
				.delimiter(",")
				.names(new String[]{"nome", "sobrenome", "idade", "email"})
				.targetType(Cliente.class)
				.build();
	}
}
