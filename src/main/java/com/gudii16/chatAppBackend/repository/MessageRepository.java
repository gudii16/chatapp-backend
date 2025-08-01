package com.gudii16.chatAppBackend.repository;

import com.gudii16.chatAppBackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRoomIdOrderByTimestampAsc(String roomId);
}
