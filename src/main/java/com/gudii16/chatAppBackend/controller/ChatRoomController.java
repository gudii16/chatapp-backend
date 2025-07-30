package com.gudii16.chatAppBackend.controller;

import com.gudii16.chatAppBackend.dto.CreateRoomRequest;
import com.gudii16.chatAppBackend.entity.ChatRoom;
import com.gudii16.chatAppBackend.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;

    @PostMapping
    public String createRoom(@RequestBody CreateRoomRequest createRoomRequest){
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(createRoomRequest.getRoomId())
                .name(createRoomRequest.getName())
                .build();
        chatRoomRepository.save(chatRoom);
        return "Room created successfully!";
    }

    @GetMapping
    public List<ChatRoom> getAllRooms(){
        return chatRoomRepository.findAll();
    }
}
