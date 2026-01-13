package com.example.lionproject2backend.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotificationEvent {
    private final Long receiverId;
    private final String title;
    private final String message;

}
