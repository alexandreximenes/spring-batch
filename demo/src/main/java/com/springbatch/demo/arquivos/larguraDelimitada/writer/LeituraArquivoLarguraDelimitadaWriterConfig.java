package com.springbatch.demo.arquivos.larguraDelimitada.writer;

import com.springbatch.demo.arquivos.larguraDelimitada.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LeituraArquivoLarguraDelimitadaWriterConfig {
	@Bean
	public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
		return items -> items.forEach(System.out::println);
	}
}
