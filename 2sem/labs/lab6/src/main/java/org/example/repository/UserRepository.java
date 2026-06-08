package org.example.repository;

import org.example.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // ищем юзера по мылу для авторизации
    Optional<User> findByEmail(String email);
    
    // чекаем уникальность мыла при регистрации
    boolean existsByEmail(String email);
}