package com.example.lionproject2backend.notification.listener;

import com.example.lionproject2backend.notification.dto.NotificationEvent;
import com.example.lionproject2backend.notification.service.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {
    private final SseService sseService;

    @EventListener
    public void handle(NotificationEvent event) {
        sseService.send(event.getReceiverId(), event.getTitle(), event.getMessage());
    }
}