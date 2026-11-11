package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados;

import java.util.Optional;

public interface ConfiguracaoRepository {
    Optional<String> recupera(String chave);

    void salva(String chave, String valor);
}