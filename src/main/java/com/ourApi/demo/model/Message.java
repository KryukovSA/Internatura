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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    /*@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")*/
    private String topic;

    @Column
    private String text;

    public Message() {

    }
}
