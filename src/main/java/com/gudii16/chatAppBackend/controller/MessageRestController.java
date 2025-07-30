package com.gudii16.chatAppBackend.controller;

import com.gudii16.chatAppBackend.entity.Message;
import com.gudii16.chatAppBackend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageRestController {
    private final MessageRepository messageRepository;

    @GetMapping("/{roomId}")
    public List<Message> getMessages(@PathVariable String roomId){
        return messageRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }

}
