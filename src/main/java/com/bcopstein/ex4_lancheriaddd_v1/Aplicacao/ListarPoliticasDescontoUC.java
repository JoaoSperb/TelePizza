package com.bcopstein.ex4_lancheriaddd_v1.Aplicacao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos.DescontoService;

@Component
public class ListarPoliticasDescontoUC {
    private DescontoService descontoService;

    @Autowired
    public ListarPoliticasDescontoUC(DescontoService descontoService) {
        this.descontoService = descontoService;
    }

    public List<PoliticaDesconto> executar() {
        return descontoService.listaPoliticas();
    }
}