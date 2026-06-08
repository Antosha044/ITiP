package org.example.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "имя не должно быть пустым")
    private String name;

    @NotBlank(message = "email обязателен")
    @Email(message = "некорректный формат email")
    private String email;

    @NotBlank(message = "пароль обязателен")
    @Size(min = 6, message = "пароль должен содержать не менее 6 символов")
    private String password;
}