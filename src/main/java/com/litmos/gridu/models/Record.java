package com.litmos.gridu.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Record {
    private String name;
    private Set<String> phones;

    public Record(String name, Set<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return name.equals(record.name) &&
                phones.equals(record.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phones);
    }

}
