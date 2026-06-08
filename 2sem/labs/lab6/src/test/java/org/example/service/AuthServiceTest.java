package org.example.service;

import org.example.exception.UserAlreadyExistsException;
import org.example.model.dto.LoginRequest;
import org.example.model.dto.RegisterRequest;
import org.example.model.entity.User;
import org.example.model.enums.UserRole;
import org.example.repository.UserRepository;
import org.example.security.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @Test
    void shouldRegisterUserSuccessfully() {
        RegisterRequest req = new RegisterRequest();
        req.setEmail("new@example.com");
        req.setPassword("qwerty");
        req.setName("олег");

        when(userRepository.existsByEmail(req.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(req.getPassword())).thenReturn("hashed_qwerty");

        authService.register(req, UserRole.ROLE_USER);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void shouldThrowWhenEmailAlreadyExists() {
        RegisterRequest req = new RegisterRequest();
        req.setEmail("exist@example.com");

        when(userRepository.existsByEmail(req.getEmail())).thenReturn(true);

        assertThrows(UserAlreadyExistsException.class, () -> authService.register(req, UserRole.ROLE_USER));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void shouldLoginAndReturnToken() {
        LoginRequest req = new LoginRequest();
        req.setEmail("test@example.com");
        req.setPassword("pass");

        when(jwtService.generateToken(req.getEmail())).thenReturn("fake.jwt.token");

        String token = authService.login(req);

        assertEquals("fake.jwt.token", token);
        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }
}