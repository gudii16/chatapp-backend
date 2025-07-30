package com.gudii16.chatAppBackend.controller;

import com.gudii16.chatAppBackend.dto.ChatMessageDto;
import com.gudii16.chatAppBackend.entity.ChatRoom;
import com.gudii16.chatAppBackend.entity.Message;
import com.gudii16.chatAppBackend.repository.ChatRoomRepository;
import com.gudii16.chatAppBackend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;

    @MessageMapping("/chat.send")
    public void sendMessage(@Payload ChatMessageDto chatMessageDto){
        Optional<ChatRoom> requestedChatRoom = chatRoomRepository.findByRoomId(chatMessageDto.getRoomId());
        if(requestedChatRoom.isEmpty()){
            return;
        }
        Message message = Message.builder()
                .sender(chatMessageDto.getSender())
                .content(chatMessageDto.getContent())
                .roomId(chatMessageDto.getRoomId())
                .timestamp(LocalDateTime.now())
                .build();
        messageRepository.save(message);

        //Broadcast to subscribers
        simpMessagingTemplate.convertAndSend("/topic/room."+ chatMessageDto.getRoomId(), chatMessageDto);
    }
}
