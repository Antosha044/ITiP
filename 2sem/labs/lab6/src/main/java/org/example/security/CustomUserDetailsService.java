package org.example.security;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.User;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // достаем юзера из базы
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("пользователь не найден"));
        
        return new CustomUserDetails(user);
    }
}