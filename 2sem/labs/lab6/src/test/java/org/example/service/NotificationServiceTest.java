package org.example.service;

import org.example.model.dto.NotificationDto;
import org.example.model.entity.Notification;
import org.example.model.entity.User;
import org.example.model.enums.NotificationChannel;
import org.example.repository.NotificationRepository;
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
class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void shouldCreateNotification() {
        User user = new User();
        user.setId(1L);

        NotificationDto dto = NotificationDto.builder()
                .title("asddasd")
                .message("fgdfg")
                .channel(NotificationChannel.EMAIL)
                .recipientId(1L)
                .build();

        Notification saved = new Notification();
        saved.setTitle(dto.getTitle());
        saved.setRecipient(user);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(notificationRepository.save(any(Notification.class))).thenReturn(saved);

        Notification result = notificationService.createNotification(dto);

        assertNotNull(result);
        assertEquals("asddasd", result.getTitle());
        assertEquals(user, result.getRecipient());
    }

    @Test
    void shouldGetNotificationById() {
        Notification notif = new Notification();
        notif.setId(42L);
        notif.setTitle("aaaaaaaaaa");

        when(notificationRepository.findById(42L)).thenReturn(Optional.of(notif));

        Notification result = notificationService.getNotificationById(42L);

        assertNotNull(result);
        assertEquals(42L, result.getId());
        assertEquals("aaaaaaaaaa", result.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenNotificationNotFound() {
        when(notificationRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            notificationService.getNotificationById(99L);
        });
    }
}