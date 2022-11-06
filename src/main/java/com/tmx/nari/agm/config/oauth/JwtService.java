package com.tmx.nari.agm.config.oauth;

import com.tmx.nari.agm.config.JwtClaim;
import com.tmx.nari.agm.model.exeption.ErrorCode;
import com.tmx.nari.agm.model.exeption.ServiceException;
import com.tmx.nari.agm.model.NariUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arshavir Hunanyan
 * Date: 9/11/21
 * Time: 3:00 AM
 */
@Service
public class JwtService {

    public static final SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_TYPE_HEADER = "typ";
    public static final List<String> REQUIRED_CLAIMS = List.of(JwtClaim.UID.getValue(), JwtClaim.SUB.getValue(), JwtClaim.EMAIL.getValue());

    private final String jwtSecret;
    private final long expiration;

    public JwtService(
            @Value("${nari.platform.agm.jwt-secret}") String jwtSecret,
            @Value("${nari.platform.agm.jwt-expiration}") long jwtexpiration

    ) {
        this.jwtSecret = jwtSecret;
        this.expiration = jwtexpiration;
    }

    public String createJwt(NariUserDetails user) {
        final Key signingKey = new SecretKeySpec(jwtSecret.getBytes(), algorithm.getJcaName());
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaim.UID.getValue(), user.getId());
        claims.put(JwtClaim.SUB.getValue(), user.getEmail());
        claims.put(JwtClaim.EMAIL.getValue(), user.getEmail());
        return Jwts.builder()
                .setId(user.getId())
                .setExpiration(Date.from(Instant.now().plusMillis(expiration)))
                .setHeaderParam(TOKEN_TYPE_HEADER, TOKEN_TYPE)
                .addClaims(claims)
                .signWith(algorithm, signingKey)
                .compact();
    }


    private void validate(Jwt jwt) {
        if (!jwt.getClaims().keySet().containsAll(REQUIRED_CLAIMS)) {
            throw new ServiceException("Missing required claims", ErrorCode.VALIDATION);
        }
    }
}