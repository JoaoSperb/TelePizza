package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Dados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.UsuarioRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.CabecalhoCardapio;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.PerfilUsuario;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.Usuario;

@Component 
public class UsuarioRepositoryJDBC implements UsuarioRepository{
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UsuarioRepositoryJDBC(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Usuario recuperaPorEmail(String email) {
        String sql = "SELECT email, senha, perfil FROM usuarios WHERE email = ?";

        List<Usuario> usuarios = this.jdbcTemplate.query(
            sql,
            ps -> ps.setString(1, email),
            (rs, rowNum) -> new Usuario(
                rs.getString("email"),
                rs.getString("senha"),
                PerfilUsuario.valueOf(rs.getString("perfil"))
            )
        );

        if (usuarios.isEmpty()) {
            return null;
        }

        return usuarios.getFirst();
    }

    @Override
    public List<Usuario> usuariosRegistrados(){
        String sql =  "SELECT email, senha, perfil FROM usuarios";
        
        List<Usuario> usuarios_registrados = this.jdbcTemplate.query(
            sql,
            ps->{},
            (rs, rowNum) -> new Usuario(rs.getString("email"), rs.getString("senha"), PerfilUsuario.valueOf(rs.getString("perfil")))
        );

        return usuarios_registrados;
    } 
}
