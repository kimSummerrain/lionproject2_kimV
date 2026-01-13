package com.example.lionproject2backend.notification.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

@Service
public class SseService {
    private final Map<Long,SseEmitter> emitters = new ConcurrentHashMap<>();

    public SseEmitter createEmitter(Long userId) {
        SseEmitter emitter = new SseEmitter(60*1000L);
        emitters.put(userId, emitter);
        emitter.onCompletion(() -> emitters.remove(userId));
        emitter.onTimeout(() -> emitters.remove(userId));
        return emitter;
    }
    public void sendNotification(Long userId,String title, String message){
        SseEmitter emitter= emitters.get(userId);
        if(emitter!=null){
            //만약 userId넣었는데 아무것도 없으면??
            return;
    
    }
        try{
            emitter.send(SseEmitter.event()
                    .name("notification")
                    .data(Map.of("title",title,"message",message)));
        }catch(IOException e){
            //예외 처리르 좀 더 빡세게 할까
            emitters.remove(userId);
        }

}
}
