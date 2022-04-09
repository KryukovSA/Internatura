package com.ourApi.demo.service;

import com.ourApi.demo.model.entity.Message;
import com.ourApi.demo.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ourApi.demo.utils.TestUtils.initializeListMessage;
import static com.ourApi.demo.utils.TestUtils.initializeMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    private MessageRepository repository;
    private MessageService service;
    private Message message;
    private ArrayList<Message> listMessage;

    @BeforeEach
    void setUp(){
        message = initializeMessage();
        listMessage = initializeListMessage();
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
    public void when_getMessage_thenNotFound() {
        when(repository.getMessageByTopic("topic1")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> service.getMessage("topic1"));
        verify(repository, times(1)).getMessageByTopic("topic1");
    }

    @Test
    public void useNumberOfInteractions_SaveFlush() {
        service.addMessage(message);
        verify(repository, times(1)).saveAndFlush(message);
    }

    @Test
    public void useNumberOfInteractions_NotSaveFlush(){
      message.setTopic(null);
        try {
            service.addMessage(message);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex);
        }
        verify(repository, times(0)).saveAndFlush(message);
    }

    @Test
    public void useNumberOfInteractionsDelete() {
        when(repository.findAll()).thenReturn(listMessage);
        when(repository.getMessageByTopic(anyString())).thenReturn(message);
        doNothing().when(repository).deleteMessageByTopic("topic1");
        service.deleteMessage("topic1");
        verify(repository, times(1)).findAll();
        verify(repository, times(1)).deleteMessageByTopic("topic1");
    }

    @Test
    public void when_getAll_thenSuccess() {
        when(repository.findAll()).thenReturn(listMessage);
        assertEquals(listMessage, service.getAllMessages());
        verify(repository, times(2)).findAll();
    }

    @Test
    public void when_getAllMessages_thenNotFound() {
        when(repository.findAll()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> service.getAllMessages());
        verify(repository, times(1)).findAll();
    }
}
