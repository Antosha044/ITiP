package org.example.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "email обязателен")
    @Email(message = "некорректный формат email")
    private String email;

    @NotBlank(message = "пароль обязателен")
    private String password;
}