package org.example.controller;

import org.example.mapper.NotificationMapper;
import org.example.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class)
@AutoConfigureMockMvc(addFilters = false) 
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService;

    @MockBean
    private NotificationMapper notificationMapper;

    @MockBean
    private org.example.security.JwtService jwtService;

    @MockBean
    private org.example.security.JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockBean
    private org.example.security.CustomUserDetailsService customUserDetailsService;

    @Test
    void shouldReturnOkForRecentNotifications() throws Exception {
        when(notificationService.getRecentNotifications()).thenReturn(List.of());

        mockMvc.perform(get("/notifications/recent"))
                .andExpect(status().isOk());
    }
}