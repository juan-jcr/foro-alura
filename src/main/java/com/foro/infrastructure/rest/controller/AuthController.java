package com.foro.infrastructure.rest.controller;

import com.foro.application.service.AuthService;
import com.foro.infrastructure.rest.dto.LoginDto;
import com.foro.infrastructure.rest.dto.RegisterDto;
import com.foro.infrastructure.rest.dto.TokenResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticacion", description = "Controlador para autenticación")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            summary = "Usuario de inicio de sesión",
            description = "Autenticar a un usuario y devolver el token de autenticación.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Solicitud de autenticación con email y contraseña",
                    required = true
            )
    )
    @PostMapping("/log-in")
    public TokenResponseDto login(@RequestBody @Valid LoginDto loginDto){
        return authService.login(loginDto);
    }

    @Operation(
            summary = "Registro de usuario",
            description = "Registrar a un usuario y devolver el token de autenticación.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Solicitud de registro con nombre email y contraseña",
                    required = true
            )
    )
    @PostMapping("/sign-up")
    public TokenResponseDto register(@RequestBody @Valid RegisterDto registerDto){
        return authService.register(registerDto);
    }
}
