package com.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApiApplication {
	
	/*
	 * Referência do arquivo application.properties
	@Value("${quantidade.unidade}")
	private int qtd;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}
	
	/*
	 * Primeiro método a ser chamado após inicialização do método main
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println(this.qtd);
		};
	}
	*/

}

