package com.example.ejemploSecurity2.security.jwt.access;

import com.example.ejemploSecurity2.user.model.User;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.SignatureException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private long jwtLifeInMinutes;

    private SecretKey seecretKey;

    public String generateToken(User user){

        Date tokenExpirationDate =
                Date.from(LocalDateTime
                        .now()
                        .plusMinutes(jwtLifeInMinutes)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                );

        return Jwts.builder()
                .header().type(TOKEN_TYPE)
                .and()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(tokenExpirationDate)
                .signWith(seecretKey)
                .compact();
    }


    public UUID getUserIdFromAccessToken(String token){
        String sub = jwtParser.parseClaimsJws(token).getBody().getSubject()
    }

    public boolean validateAccessToken(String token) {
        try {
            jwtParser.parseClaimsJws(token);
            return true;
        }catch(SignatureException | MalformedJwtException | ExpiredJwtException | Unsug){
            throw new JwtException(ex.getMessage());
        }

    }
}
