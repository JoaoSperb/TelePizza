package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.ConfiguracaoRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.PoliticaDescontoRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;

@Service
public class DescontoService {
    public static final String CHAVE_POLITICA_CORRENTE = "politica_desconto_corrente";

    private PoliticaDescontoRepository politicaDescontoRepository;
    private ConfiguracaoRepository configuracaoRepository;

    @Autowired
    public DescontoService(PoliticaDescontoRepository politicaDescontoRepository,
                           ConfiguracaoRepository configuracaoRepository){
        this.politicaDescontoRepository = politicaDescontoRepository;
        this.configuracaoRepository = configuracaoRepository;
    }

    public List<PoliticaDesconto> listaPoliticas(){
        return politicaDescontoRepository.todas();
    }

    public void definirPoliticaCorrente(String codigo){
        if (!politicaDescontoRepository.existe(codigo))
            throw new IllegalArgumentException("Politica de desconto inexistente: " + codigo);
        configuracaoRepository.salva(CHAVE_POLITICA_CORRENTE, codigo);
    }
}