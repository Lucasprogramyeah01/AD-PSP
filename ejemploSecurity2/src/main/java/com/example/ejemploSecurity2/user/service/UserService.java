package com.example.ejemploSecurity2.user.service;

import com.example.ejemploSecurity2.user.dto.CreateUserRequest;
import com.example.ejemploSecurity2.user.model.User;
import com.example.ejemploSecurity2.user.model.UserRole;
import com.example.ejemploSecurity2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserRequest createUserRequest){
        User user = User.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .roles(Set.of(UserRole.USER))
            .build();

        return userRepository.save(user);
    }

}
