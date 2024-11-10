package com.foro.infrastructure.rest.controller;

import com.foro.application.service.AuthService;
import com.foro.infrastructure.rest.dto.LoginDto;
import com.foro.infrastructure.rest.dto.RegisterDto;
import com.foro.infrastructure.rest.dto.TokenResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/log-in")
    public TokenResponseDto login(@RequestBody @Valid LoginDto loginDto){
        return authService.login(loginDto);
    }
    @PostMapping("/sign-up")
    public TokenResponseDto register(@RequestBody @Valid RegisterDto registerDto){
        return authService.register(registerDto);
    }
}
