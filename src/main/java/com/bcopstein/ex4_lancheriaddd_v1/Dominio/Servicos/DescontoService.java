package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.PoliticaDescontoRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;

@Service
public class DescontoService {

    private PoliticaDescontoRepository politicaDescontoRepository;

    @Autowired
    public DescontoService(PoliticaDescontoRepository politicaDescontoRepository) {
        this.politicaDescontoRepository = politicaDescontoRepository;
    }

    public List<PoliticaDesconto> listaPoliticas() {
        return politicaDescontoRepository.todas();
    }

    public void definirPoliticaCorrente(String codigo) {
        if (!politicaDescontoRepository.existe(codigo))
            throw new IllegalArgumentException(
                "Politica de desconto inexistente: " + codigo
            );

        politicaDescontoRepository.definirCorrente(codigo);
    }
}