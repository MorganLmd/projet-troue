package com.m1iii.cybersecu.projettroue.security;

import com.m1iii.cybersecu.projettroue.security.jwt.JwtConfig;
import com.m1iii.cybersecu.projettroue.security.jwt.JwtTokenVerifier;
import com.m1iii.cybersecu.projettroue.security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.m1iii.cybersecu.projettroue.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static com.m1iii.cybersecu.projettroue.security.ApplicationUserRole.*;

/**
 * Classe de configuration de spring sécurity
 */
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable() // On disable CSRF car l'api n'a pas vocation a recevoir les requetes d'un utilisateur final (recommandation doc spring security)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // On défini la gestion des sessions comme stateless
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey)) // on passe par le premier filtre du vérification des credentials
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class) // on passe par le deuxième filtre de vérification du token jwt
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll() // on autorise l'accès à la bdd h2 en mémoire (pour du test uniquement !!)
                .antMatchers("/api/**").hasAnyRole(CLIENT.name(), ADMIN.name()) // on donne anncès aux endpoints en dessous de /api/ aux clients et admin
                .anyRequest()
                .authenticated();

        //h2 console config
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}