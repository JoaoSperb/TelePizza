package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Apresentacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.ex4_lancheriaddd_v1.Aplicacao.DefinirPoliticaDescontoCorrenteUC;
import com.bcopstein.ex4_lancheriaddd_v1.Aplicacao.ListarPoliticasDescontoUC;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;

@RestController
@RequestMapping("/descontos")
public class DescontoController {

    private ListarPoliticasDescontoUC listarPoliticasDescontoUC;
    private DefinirPoliticaDescontoCorrenteUC definirPoliticaDescontoCorrenteUC;

    @Autowired
    public DescontoController(
            ListarPoliticasDescontoUC listarPoliticasDescontoUC,
            DefinirPoliticaDescontoCorrenteUC definirPoliticaDescontoCorrenteUC) {

        this.listarPoliticasDescontoUC = listarPoliticasDescontoUC;
        this.definirPoliticaDescontoCorrenteUC = definirPoliticaDescontoCorrenteUC;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<PoliticaDesconto> listarPoliticas() {
        return listarPoliticasDescontoUC.executar();
    }

    @PutMapping("/corrente/{codigo}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> definirPoliticaCorrente(
            @PathVariable("codigo") String codigo) {

        try {
            definirPoliticaDescontoCorrenteUC.executar(codigo);

            return ResponseEntity.ok(
                    "Politica de desconto corrente definida: " + codigo
            );

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}