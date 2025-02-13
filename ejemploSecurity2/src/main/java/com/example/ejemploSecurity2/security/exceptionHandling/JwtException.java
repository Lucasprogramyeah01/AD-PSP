package com.example.ejemploSecurity2.security.exceptionHandling;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
