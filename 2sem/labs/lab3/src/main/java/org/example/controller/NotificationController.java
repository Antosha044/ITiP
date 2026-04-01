package org.example.controller;

import org.example.service.NotificationManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final ApplicationContext context;

    public NotificationController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/notify")
    public String notify(@RequestParam String message, @RequestParam String email) {
        NotificationManager manager = context.getBean(NotificationManager.class);
        manager.notify(message, email);
        return "Уведомление отправлено через Java Config";
    }
}