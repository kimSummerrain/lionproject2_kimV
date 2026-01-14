package com.example.lionproject2backend.notification.controller;

import com.example.lionproject2backend.notification.service.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class NotificationController {
    private final SseService sseService;

    @GetMapping("/api/notifications/subscribe")
    public SseEmitter subscribe(@RequestParam Long userId) {
        return sseService.subscribe(userId);
    }
}