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

@SpringBootApplication
public class SpringBootApiApplication {
	
	/* Essa anotação serve para injetar um componente dentro de outro componente */
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	/*
	 * Referência do arquivo application.properties
	@Value("${quantidade.unidade}")
	private int qtd;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			/* Persistindo uma entidade no banco de dados */
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Empresa 1");
			empresa.setCnpj("89510341000110");
			this.empresaRepository.save(empresa);
						
			/* Consultando todas as empresas no banco de dados */
			List<Empresa> empresas = this.empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			/* Consultando empresas por ID */
			Optional<Empresa> empresaDB = this.empresaRepository.findById(1L);
			System.out.println(empresaDB);
			
			/* Consultando empresa por CNPJ */
			Empresa empresaCnpj = this.empresaRepository.findByCnpj("89510341000110");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			/* Deletando uma empresa por ID */
			this.empresaRepository.deleteById(1L);
			
		};
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

