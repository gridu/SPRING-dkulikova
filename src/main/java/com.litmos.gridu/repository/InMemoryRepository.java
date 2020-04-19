package com.litmos.gridu.repository;

import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Record;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InMemoryRepository {
    List<Record> findAllRecords();

    void deleteRecord(String name) throws ResourceNotFoundException;

    void updatePhone(String name, String newPhone, String oldPhone) throws ResourceNotFoundException;

    void addRecord(Record record);

    Record findAllPhonesByName(String name) throws ResourceNotFoundException;

    void deletePhone(String name, String phone) throws ResourceNotFoundException;

    void addPhoneToName(String name, String phone) throws ResourceNotFoundException;
}
