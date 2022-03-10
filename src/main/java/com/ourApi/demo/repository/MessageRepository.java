package com.ourApi.demo.repository;
import com.ourApi.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    Message saveAndFlush(Message msg);
    Message getMessageByTopic(String topic);
    List<Message> findAll();
    void deleteMessageByTopic(String topic);
}
