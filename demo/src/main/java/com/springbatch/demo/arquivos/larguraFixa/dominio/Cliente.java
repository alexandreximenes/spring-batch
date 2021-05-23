package com.springbatch.demo.arquivos.larguraFixa.dominio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
	private String nome;
	private String sobrenome;
	private String idade;
	private String email;
}
