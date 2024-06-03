package br.com.api.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.backend.modelo.BeneficioModelo;

public interface BeneficioRepositorio extends JpaRepository<BeneficioModelo, Long>{
    
}
