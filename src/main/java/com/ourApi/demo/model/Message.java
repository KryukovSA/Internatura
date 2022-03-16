package com.ourApi.demo.model;

import com.ourApi.demo.usersDatatype.UserDatatype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "message")
public class Message {
    @Id
    private String topic;

    @Column
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private UserDatatype.Importance importance;

    @Column
    private String keyword;

    @Column
    private String author;
}
