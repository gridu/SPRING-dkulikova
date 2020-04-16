package com.litmos.gridu.DTOs;

import java.util.Set;

public class PhoneBookRecordDTO {
    private String name;
    private Set<String> phones;

    public PhoneBookRecordDTO(String name, Set<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
}
