package com.example.ejemploSecurity2.security.jwt.refresh;

import com.example.ejemploSecurity2.user.model.User;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("jwt.refresh.duration")
    private int durationInMinutes;

    public RefreshToken create(User user){
        return refreshTokenRepository.save(
            RefreshToken.builder()
                    .user(user)
                    .token(UUID.randomUUID())
        )
    }

}
