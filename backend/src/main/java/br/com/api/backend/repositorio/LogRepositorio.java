package br.com.api.backend.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.backend.modelo.LogModelo;

public interface LogRepositorio extends JpaRepository<LogModelo, Long>{

}