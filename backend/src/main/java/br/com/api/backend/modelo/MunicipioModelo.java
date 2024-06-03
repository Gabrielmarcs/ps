package br.com.api.backend.modelo;

import lombok.Data;

@Data
public class MunicipioModelo {
    private String codigoIbge;
    private String nomeIbge;
    private String codigoRegiao;
    private String nomeRegiao;
    private String pais;
    private UfModelo uf;
    
}