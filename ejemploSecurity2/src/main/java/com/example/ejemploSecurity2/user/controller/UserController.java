package com.example.ejemploSecurity2.user.controller;

import com.example.ejemploSecurity2.security.jwt.access.JwtService;
import com.example.ejemploSecurity2.user.dto.CreateUserRequest;
import com.example.ejemploSecurity2.user.dto.LoginRequest;
import com.example.ejemploSecurity2.user.dto.UserResponse;
import com.example.ejemploSecurity2.user.model.User;
import com.example.ejemploSecurity2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @GetMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.createUser(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username();
                        loginRequest.password();
                );
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user, accessToken));
    }

    @GetMapping("/me")
    public UserResponse me(@AuthenticationPrincipal User user){
        return UserResponse.of(user);
    }

}
