package com.fredson.springsecutiryexample.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String extractUsername(String jwt) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignInKey()).parseClaimsJwt(token).getBody();
    }
}
