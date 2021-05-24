package com.springbatch.demo.jdbc.reader;

import com.springbatch.demo.jdbc.dominio.Cliente;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.HibernateCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderConfig {


	@Bean
	public JdbcCursorItemReader<Cliente> jdbcCursorReader(@Qualifier("springDataSource")DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("jdbcCursorReader")
				.sql("SELECT * FROM cliente")
				.dataSource(dataSource)
				.rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
				.build();
	}

	//https://docs.spring.io/spring-batch/docs/current/reference/html/index.html
//	@Bean
	public HibernateCursorItemReader<Cliente> jdbcCursorReader2(@Qualifier("springDataSource")DataSource dataSource) {
//		return new JdbcPagingItemReaderBuilder<Cliente>()
//		return new HibernateCursorItemReaderBuilder<Cliente>()
		return new HibernateCursorItemReaderBuilder<Cliente>()
				.name("jdbcCursorReader")
				.nativeQuery("SELECT * FROM cliente")
				.entityClass(Cliente.class)
				.build();
	}

	/*
	* Neo4jItemReader
	MongoItemReader
	HibernateCursorItemReader
	HibernatePagingItemReader
	RepositoryItemReader
	SimpleMailMessageItemWriter
*/

	/*
	* @Bean
	public JsonItemReader<Trade> jsonItemReader() {
	   return new JsonItemReaderBuilder<Trade>()
                 .jsonObjectReader(new JacksonJsonObjectReader<>(Trade.class))
                 .resource(new ClassPathResource("trades.json"))
                 .name("tradeJsonItemReader")
                 .build();
	}
	* */

	/*
	@Bean
	public XStreamMarshaller tradeMarshaller() {
		Map<String, Class> aliases = new HashMap<>();
		aliases.put("trade", Trade.class);
		aliases.put("price", BigDecimal.class);
		aliases.put("isin", String.class);
		aliases.put("customer", String.class);
		aliases.put("quantity", Long.class);

		XStreamMarshaller marshaller = new XStreamMarshaller();

		marshaller.setAliases(aliases);

		return marshaller;
	}*/

	//https://docs.spring.io/spring-batch/docs/current/reference/html/index.html

}
