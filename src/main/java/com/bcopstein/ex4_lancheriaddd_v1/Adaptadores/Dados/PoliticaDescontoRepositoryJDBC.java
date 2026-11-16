package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Dados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.PoliticaDescontoRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PoliticaDesconto;

@Component 
public class PoliticaDescontoRepositoryJDBC implements PoliticaDescontoRepository{
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PoliticaDescontoRepositoryJDBC(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PoliticaDesconto> todas() {
        String sql = "SELECT codigo, descricao, corrente FROM politicas_desconto";

        return jdbcTemplate.query(
            sql,
            (rs, rowNum) -> new PoliticaDesconto(
                rs.getString("codigo"),
                rs.getString("descricao"),
                rs.getBoolean("corrente")
            )
        );
    }
    
    @Override
    public boolean existe(String codigo) {
        String sql = "SELECT EXISTS (SELECT 1 FROM politicas_desconto WHERE codigo = ?)";

        return jdbcTemplate.queryForObject(sql, Boolean.class, codigo);
    }

    @Override
    public void definirCorrente(String codigo)
    {
            jdbcTemplate.update(
            "UPDATE politicas_desconto SET corrente = CASE WHEN codigo = ? THEN TRUE ELSE FALSE END", codigo);
    }
}
