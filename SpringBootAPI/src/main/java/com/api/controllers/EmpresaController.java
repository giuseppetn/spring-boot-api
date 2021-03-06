package com.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dtos.EmpresaDto;
import com.api.responses.Response;

@RestController
@RequestMapping("/api/v1/empresas")

public class EmpresaController {
	
	/**
	 * @param nome
	 * @return ResponseEntity<Response <String>>
	 * */

	@PostMapping
	public ResponseEntity<Response <EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result) {
		
		Response<EmpresaDto> response = new Response<EmpresaDto>(); 
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
		
	}
	
}
