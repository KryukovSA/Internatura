package com.ourApi.demo.model.entity;

import com.ourApi.demo.model.datatype.UserDatatype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    private Date createdDataTime;
}
