package com.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors((cors)-> cors.disable())
                .csrf((csrf)-> csrf.disable())
                .authorizeHttpRequests((registry ->
                        registry
                                .anyRequest().authenticated()))
                .oauth2Login(oAuth2Login ->
                        oAuth2Login.defaultSuccessUrl("http://localhost:3000/dashboard",true))
                .build();
    }
}
