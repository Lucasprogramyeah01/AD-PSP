package com.example.ejemploSecurity2.user.dto;

public record CreateUserRequest(
        String username,
        String password,
        String verifyPassword
) {
}
