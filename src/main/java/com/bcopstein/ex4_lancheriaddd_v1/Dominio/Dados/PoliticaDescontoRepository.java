package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados;

import java.util.List;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;

public interface PoliticaDescontoRepository {
    List<PoliticaDesconto> todas();
    boolean existe(String codigo);
}