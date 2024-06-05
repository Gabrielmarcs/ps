package br.com.api.backend.servico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.api.backend.modelo.LogModelo;
import br.com.api.backend.repositorio.LogRepositorio;

@Service
public class ConsultaServico {
    
    @Autowired
    private RestTemplate rt;

    @Autowired
    private LogRepositorio lr;

    public String consultarBeneficio(String mesAno, String codIbge) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("chave-api-dados", "key");
        HttpEntity<String> entity = new HttpEntity<>(headers);
    
        String apiUrl = "https://api.portaldatransparencia.gov.br/api-de-dados/bpc-por-municipio?mesAno=" + mesAno + "&codigoIbge=" + codIbge + "&pagina=1";
        
        try {
            ResponseEntity<String> response = rt.exchange(apiUrl, HttpMethod.GET, entity, String.class);
            String rp =  response.getBody();

            if ("[]".equals(rp) || rp == null || rp.isEmpty()) {
                return "Nenhum dado encontrado para código " + codIbge + " e mês/ano " + mesAno;
            }

            LogModelo lm = new LogModelo();
            lm.setTempo(LocalDateTime.now());
            lm.setMensagem("Sucesso consulta de " + codIbge +" "+ mesAno.substring(4) + "/" + mesAno.substring(0,4));
            lr.save(lm);
            return rp;

        } catch (RestClientException e) {
            return "Erro " + e.getMessage();
        }
    }

}

