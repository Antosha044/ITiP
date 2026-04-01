package org.example.config;

import org.example.service.EmailService;
import org.example.service.SmsService;
import org.example.service.PushService;
import org.example.service.NotificationManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // @Bean
    // public EmailService emailService() {
    //     return new EmailService();
    // }

    // @Bean
    // public SmsService smsService() {
    //     return new SmsService();
    // }

    // @Bean
    // public NotificationManager notificationManager() {
    //     return new NotificationManager(pushService);
    // }
}