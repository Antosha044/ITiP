package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.model.dto.LoginRequest;
import org.example.model.dto.RegisterRequest;
import org.example.model.enums.UserRole;
import org.example.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody @Valid RegisterRequest request) {
        authService.register(request, UserRole.ROLE_USER);
        return Map.of("message", "пользователь успешно зарегистрирован");
    }

    // регистрация админа (самостоятельное задание 1)
    @PostMapping("/register-admin")
    public Map<String, String> registerAdmin(@RequestBody @Valid RegisterRequest request) {
        authService.register(request, UserRole.ROLE_ADMIN);
        return Map.of("message", "администратор успешно зарегистрирован");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody @Valid LoginRequest request) {
        String token = authService.login(request);
        return Map.of("token", token);
    }
}