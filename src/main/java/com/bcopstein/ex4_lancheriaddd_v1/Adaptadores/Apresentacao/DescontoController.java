package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Apresentacao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.ex4_lancheriaddd_v1.Aplicacao.ListarPoliticasDescontoUC;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;

@RestController
@RequestMapping("/descontos")
public class DescontoController {
    
    private ListarPoliticasDescontoUC listarPoliticasDescontoUC;

    @Autowired
    public DescontoController(ListarPoliticasDescontoUC listarPoliticasDescontoUC) {
        this.listarPoliticasDescontoUC = listarPoliticasDescontoUC;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<PoliticaDesconto> listarPoliticas() {
        return listarPoliticasDescontoUC.executar();
    }
}