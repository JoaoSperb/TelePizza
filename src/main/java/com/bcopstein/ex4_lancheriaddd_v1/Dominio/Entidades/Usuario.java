package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades;

public class Usuario {
    private String email;
    private String senha;
    private PerfilUsuario perfil;

    public Usuario(String email, String senha,PerfilUsuario perfil){
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }


    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
        this.perfil = PerfilUsuario.CLIENTE;
    }


    public String getEmail(){return email;}
    public void setSenha(String nova_senha){this.senha = nova_senha;}
    
}
