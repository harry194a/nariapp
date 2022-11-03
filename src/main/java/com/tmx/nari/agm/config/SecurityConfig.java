package com.tmx.nari.agm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by Harutyun Badeyan
 * Date: 04.10.22
 * Time: 01:00
 */
@Component
public class SecurityConfig {

    private static final String JWT_ALGORITHM = "HmacSHA256";

    private final String secret;

    @Autowired
    public SecurityConfig(
            @Value("${nari.platform.agm.jwt-secret}") String secret) {
        this.secret = secret;
    }


    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/oauth/token", "/v2/api-docs", "/api/user/create",
                        "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .opaqueToken()
                .introspector(new JwtTokenInspector(jwtDecoder()));
        return http.build();
    }

    public JwtDecoder jwtDecoder() {
        SecretKey key = new SecretKeySpec(secret.getBytes(), JWT_ALGORITHM);
        return NimbusJwtDecoder.withSecretKey(key).build();
    }
}
