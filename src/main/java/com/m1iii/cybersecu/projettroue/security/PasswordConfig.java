package com.m1iii.cybersecu.projettroue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    /**
     * retourne un encoder BCrypt pour les chiffrement des mots de passe
     * force à 10 pour une sécurité efficace, sans trop ralentir l'application mais en limitant la capacité des attaques par force brute
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
