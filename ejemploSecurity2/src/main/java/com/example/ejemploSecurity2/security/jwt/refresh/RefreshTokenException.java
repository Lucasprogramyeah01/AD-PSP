package com.example.ejemploSecurity2.security.jwt.refresh;

import com.example.ejemploSecurity2.security.exceptionHandling.JwtException;

public class RefreshTokenException extends JwtException {
    public RefreshTokenException(String s) {
        super(s);
    }
}
