package com.gudii16.chatAppBackend.dto;

import lombok.Data;

@Data
public class CreateRoomRequest {
    private String roomId;
    private String name;
}
