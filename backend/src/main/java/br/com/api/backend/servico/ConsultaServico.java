package br.com.api.backend.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaServico {
    
    @Autowired
    private RestTemplate restTemplate;

    public String consultarBeneficios(String mesAno, String codIbge) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("chave-api-dados", "key");
        HttpEntity<String> entity = new HttpEntity<>(headers);
    
        String apiUrl = "https://api.portaldatransparencia.gov.br/api-de-dados/bpc-por-municipio?mesAno=" + mesAno + "&codigoIbge=" + codIbge + "&pagina=1";
        
        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (RestClientException e) {
            return "Erro ao consultar os benefícios: " + e.getMessage();
        }
    }
}

