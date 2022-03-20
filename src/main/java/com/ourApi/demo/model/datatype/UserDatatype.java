package com.ourApi.demo.model.datatype;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDatatype {
    public enum Importance{
        LOW,
        MEDIUM,
        HIGH
    }
}
