package com.ourApi.demo.service;

import com.ourApi.demo.model.entity.Message;
import com.ourApi.demo.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ourApi.demo.utils.TestUtils.initializeMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    private MessageRepository repository;
    private MessageService service;
    private Message message;

    @BeforeEach
    void setUp(){
        message = initializeMessage();
        repository = mock(MessageRepository.class);
        service = spy(new MessageService(repository));
    }

    @Test
    public void when_getMessage_thenSuccess() {
        when(repository.getMessageByTopic("topic1")).thenReturn(message);
        assertEquals(message, service.getMessage("topic1"));
        verify(repository, times(1)).getMessageByTopic("topic1");
    }

    @Test
    public void useNumberOfInteractionsSaveFlush() {
        service.addMessage(message);
        verify(repository, times(1)).saveAndFlush(message);
    }


    @Test
    public void useNumberOfInteractionsDelete() {
        ArrayList listMessage = new ArrayList<Message>();
        listMessage.add(message);
        when(repository.findAll()).thenReturn(listMessage);
        doNothing().when(repository).deleteMessageByTopic("topic1");
        doNothing().when(service).deleteMessage("topic1");
        System.out.print(message);
        service.deleteMessage("topic1");
        verify(service, times(1)).deleteMessage("topic1");
        verify(repository, times(1)).deleteMessageByTopic("topic1");
        //verify(repository, times(1)).findAll();
    }

    @Test
    public void when_getAll_thenSuccess() {
        ArrayList listMessage = new ArrayList<Message>();
        listMessage.add(message);
        when(repository.findAll()).thenReturn(listMessage);
        assertEquals(listMessage, service.getAllMessage());
        verify(repository, times(2)).findAll();
    }
}
