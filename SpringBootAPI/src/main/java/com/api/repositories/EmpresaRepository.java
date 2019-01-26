package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj);

}
