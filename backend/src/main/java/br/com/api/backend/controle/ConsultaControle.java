package br.com.api.backend.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.backend.servico.ConsultaServico;

@RestController
@RequestMapping("/api/consulta")
@CrossOrigin(origins = "*")
public class ConsultaControle {
    @Autowired
    private ConsultaServico cs;

    @GetMapping("/beneficios")
    public String consulta(@RequestParam String mesAno, @RequestParam String codIbge) {
        return cs.consultarBeneficio(mesAno, codIbge);
    }
}
