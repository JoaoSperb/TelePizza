package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.CardapioRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.ConfiguracaoRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.CabecalhoCardapio;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.Cardapio;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.Produto;

@Service
public class CardapioService {
    public static final String CHAVE_CARDAPIO_CORRENTE = "cardapio_corrente";

    private CardapioRepository cardapioRepository;
    private ConfiguracaoRepository configuracaoRepository;

    @Autowired
    public CardapioService(CardapioRepository cardapioRepository,
            ConfiguracaoRepository configuracaoRepository) {
        this.cardapioRepository = cardapioRepository;
        this.configuracaoRepository = configuracaoRepository;
    }

    public Cardapio recuperaCardapio(long Id) {
        return cardapioRepository.recuperaPorId(Id);
    }

    public List<CabecalhoCardapio> recuperaListaDeCardapios() {
        return cardapioRepository.cardapiosDisponiveis();
    }

    public List<Produto> recuperaSugestoesDoChef() {
        return cardapioRepository.indicacoesDoChef();
    }

    public void definirCardapioCorrente(long id) {
        if (cardapioRepository.recuperaPorId(id) == null)
            throw new IllegalArgumentException("Cardapio inexistente: " + id);
        configuracaoRepository.salva(CHAVE_CARDAPIO_CORRENTE, String.valueOf(id));
    }

    public Cardapio recuperaCardapioCorrente() {
        String valor = configuracaoRepository.recupera(CHAVE_CARDAPIO_CORRENTE)
                .orElseThrow(() -> new IllegalStateException("Cardapio corrente nao definido"));
        return recuperaCardapio(Long.parseLong(valor));
    }
}