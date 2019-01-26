package com.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.entities.Empresa;
import com.api.repositories.EmpresaRepository;
import com.api.services.ExemploService;

@SpringBootApplication
public class SpringBootApiApplication {
	
	/* Essa anotação serve para injetar um componente dentro de outro componente */
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ExemploService exemploService;
	
	
	/*
	 * Referência do arquivo application.properties
	@Value("${quantidade.unidade}")
	private int qtd;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}
	
	/*
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			this.exemploService.testarServico();
		};
	}
	*/
	
	/*
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
		
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Empresa 1");
			empresa.setCnpj("89510341000110");
			this.empresaRepository.save(empresa);
						
			
			List<Empresa> empresas = this.empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			
			Optional<Empresa> empresaDB = this.empresaRepository.findById(1L);
			System.out.println(empresaDB);
			
			Empresa empresaCnpj = this.empresaRepository.findByCnpj("89510341000110");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			this.empresaRepository.deleteById(1L);
			
		};
	}
	*/
	
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

