package br.com.api.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.backend.modelo.ConsultaModelo;

public interface ConsultaRepositorio extends JpaRepository<ConsultaModelo, Long>{
    
}
