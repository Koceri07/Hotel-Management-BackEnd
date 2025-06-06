package org.hotelmanagement.hotelmanagementbackend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Component
public class JwtUtil {
    private static final String SECRET = "9dD8BlYZ2P2U94+ZoP7aRQgWhzL2Zx0x3Eh5gqRgSB7FCp1I6OlZz6SLaIfGCk0F";
    private final Long EXPIRATION_TIME = 1000L * 60 * 15; // 15 minutes


    private static Key getSigningKey() {
        return new SecretKeySpec(SECRET.getBytes(), 0, SECRET.getBytes().length, "HmacSHA256");
    }

    public String generateAccessToken(String username, Set<String> roles) {
        return Jwts.builder()
                .signWith(getSigningKey(), HS256)
                .setClaims(Map.of("roles", roles,
                        Claims.SUBJECT, username))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .signWith(getSigningKey(), HS256)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME * 2))
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public List<String> extractRoles(String token) {
        return (ArrayList<String>) Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("roles");

    }

    // we need to check if the token is expired or not
    public boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
