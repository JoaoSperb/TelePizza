package com.bcopstein.ex4_lancheriaddd_v1.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos.DescontoService;

@Component
public class DefinirPoliticaDescontoCorrenteUC {

    private DescontoService descontoService;

    @Autowired
    public DefinirPoliticaDescontoCorrenteUC(DescontoService descontoService) {
        this.descontoService = descontoService;
    }

    public void executar(String codigo) {
        descontoService.definirPoliticaCorrente(codigo);
    }
}