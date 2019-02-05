package com.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.entities.Empresa;
import com.api.repositories.EmpresaRepository;
import com.api.utils.SenhaUtils;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;


@SpringBootApplication
public class SpringBootApiApplication {
	
	private static final String SINGLE_IMAGE_FILE = "C:\\Users\\Giuseppe\\Pictures\\mulher-rabuda-011.jpg";
	/* Essa anotação serve para injetar um componente dentro de outro componente */
	@Autowired
	private EmpresaRepository empresaRepository;
	
	/*
	@Autowired
	private ExemploService exemploService;
	*/
	
	/*
	 * Referência do arquivo application.properties
	@Value("${quantidade.unidade}")
	private int qtd;
	*/
	
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(SpringBootApiApplication.class, args);
		
		VisualRecognition service = new VisualRecognition("2018-03-19");
		
		//service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api/v3/classify");
		
		IamOptions iamOptions = new IamOptions.Builder()
				  .apiKey("Li24xz63mNzFXEKbHT0ecmoVu0Dv5N_Zqk6wl4taGqWC")
				  .build();
		
		service.setIamCredentials(iamOptions);
		
		System.out.println("Classify an image");
		
		ClassifyOptions options = new ClassifyOptions.Builder()
				  .imagesFile(new File(SINGLE_IMAGE_FILE))
				  .build();
		
		ClassifiedImages result = service.classify(options).execute();
		
		System.out.println("Resultadooooo: " + result);
		
		//System.out.println(SenhaUtils.gerarBCrypt("123456"));
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

