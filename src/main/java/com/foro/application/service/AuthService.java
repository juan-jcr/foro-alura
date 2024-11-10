package com.foro.application.service;

import com.foro.domain.exception.AlreadyExistsException;
import com.foro.domain.exception.UnauthorizedException;
import com.foro.domain.model.Author;
import com.foro.domain.port.IAuthorPersistence;
import com.foro.infrastructure.rest.dto.LoginDto;
import com.foro.infrastructure.rest.dto.RegisterDto;
import com.foro.infrastructure.rest.dto.TokenResponseDto;
import com.foro.infrastructure.security.utils.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final IAuthorPersistence authorPersistence;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthService(IAuthorPersistence authorPersistence, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authorPersistence = authorPersistence;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    public TokenResponseDto register(RegisterDto registerDto) {
        Optional<Author>   findAuthor = authorPersistence.findByEmail(registerDto.getEmail());

        if(findAuthor.isPresent()){
            throw new AlreadyExistsException("El campo email ya existe");
        }
        Author author = new Author();
        author.setName(registerDto.getName());
        author.setEmail(registerDto.getEmail());
        author.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        authorPersistence.save(author);

        String token = jwtUtils.generateToken(author.getEmail());
        return new TokenResponseDto(token);
    }

    public TokenResponseDto login(LoginDto loginDto) {
        Optional<Author> user = authorPersistence.findByEmail(loginDto.getEmail());

        if (user.isPresent() && passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword())) {
            String token = jwtUtils.generateToken(user.get().getEmail());
            return new TokenResponseDto(token);
        }

        throw new UnauthorizedException("Credenciales inválidas");
    }
}
