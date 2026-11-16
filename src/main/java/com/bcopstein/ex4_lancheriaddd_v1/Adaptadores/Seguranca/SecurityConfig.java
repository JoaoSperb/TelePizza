package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Seguranca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.CommandLineRunner;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DetalhesUsuarioService DetalhesUsuarioService;

    public SecurityConfig(DetalhesUsuarioService DetalhesUsuarioService) {
        this.DetalhesUsuarioService = DetalhesUsuarioService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(DetalhesUsuarioService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authenticationProvider(authenticationProvider())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .httpBasic(basic -> {});

        return http.build();
    }

    @Bean
    public CommandLineRunner gerarHash(PasswordEncoder passwordEncoder) {
        return args -> {
            System.out.println("Hash: " + passwordEncoder.encode("adminpass"));
        };
    } // pra testar inicialmente o hash da senha.

}