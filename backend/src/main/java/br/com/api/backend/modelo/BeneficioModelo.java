package br.com.api.backend.modelo;

import lombok.Data;

@Data
public class BeneficioModelo {
    private long id;
    private String dataReferencia;
    private MunicipioModelo municipio;
    private double valor;
    private int qtdeBeneficiados;
    private TipoModelo tipo;
}
