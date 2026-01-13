package com.example.lionproject2backend.notification.listener;
import com.example.lionproject2backend.notification.service.SseService;
public class NotificationEventListener {

    private final SseService sseService;

    @EventListener
    public void handle(NotificationEvent event){
        sseService.sendNotification(event.getReceiverId(), event.getTitle(), event.getMessage());
    }

}
