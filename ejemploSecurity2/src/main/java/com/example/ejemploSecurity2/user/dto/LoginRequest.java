package com.example.ejemploSecurity2.user.dto;

public record LoginRequest(
        String username,
        String password
) {
}
