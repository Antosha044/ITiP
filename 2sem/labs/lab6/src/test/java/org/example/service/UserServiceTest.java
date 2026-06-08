package org.example.service;

import org.example.model.dto.UserDto;
import org.example.model.entity.User;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldCreateUser() {
        UserDto dto = UserDto.builder()
                .name("Иван Иванов")
                .email("ivan@example.com")
                .build();

        User savedUser = new User();
        savedUser.setName(dto.getName());
        savedUser.setEmail(dto.getEmail());

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User result = userService.createUser(dto);

        assertNotNull(result);
        assertEquals("Иван Иванов", result.getName());
    }

    @Test
    void shouldGetUserById() {
        User user = new User();
        user.setId(10L);
        user.setName("тестовый юзер");

        when(userRepository.findById(10L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(10L);

        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("тестовый юзер", result.getName());
    }

    @Test
    void shouldDeleteUser() {
        User user = new User();
        user.setId(5L);

        when(userRepository.findById(5L)).thenReturn(Optional.of(user));

        userService.deleteUser(5L);

        verify(userRepository, times(1)).delete(user);
    }
}