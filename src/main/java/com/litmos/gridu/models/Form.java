package com.litmos.gridu.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Form {
    private String name;
    private String phone;

    public Form(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
