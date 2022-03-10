package com.ourApi.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity(name = "message")
public class Message {
    @Id
    private String topic;

    @Column
    private String text;

    public Message() {

    }
}
