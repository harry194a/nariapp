package com.tmx.nari.agm.config;

import org.springframework.security.oauth2.core.DefaultOAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionException;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Arshavir Hunanyan
 * Date: 9/11/21
 * Time: 3:15 AM
 */
public class JwtTokenInspector implements OpaqueTokenIntrospector {

    private final JwtDecoder jwtDecoder;

    public JwtTokenInspector(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        try {
            Jwt jwt = jwtDecoder.decode(token);
            checkJwtClaims(jwt);
            return new DefaultOAuth2AuthenticatedPrincipal(
                    jwt.getSubject(),
                    jwt.getClaims(),
                    new ArrayList<>() //Should be replaced with user authorities. not in current scope
            );
        } catch (JwtException e) {
            throw new OAuth2IntrospectionException("Invalid JWT token", e);
        }
    }

    private void checkJwtClaims(Jwt jwt) {
        List<String> requiredClaims = Arrays.asList(
                JwtClaim.UID.getValue(),
                JwtClaim.SUB.getValue(),
                JwtClaim.EXPIRATION.getValue()
        );
        if (!jwt.getClaims().keySet().containsAll(requiredClaims)) {
            throw new OAuth2IntrospectionException("JWT token doesn't contain all required claims");
        }
    }
}
