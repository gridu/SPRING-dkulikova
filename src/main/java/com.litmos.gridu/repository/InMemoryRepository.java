package com.litmos.gridu.repository;

import com.litmos.gridu.exceptions.ResourceNotFoundException;

import java.util.Map;
import java.util.Set;

public interface InMemoryRepository {

    Map<String, Set<String>> findAll();

    Set<String> findAllPhonesByName(String name) throws ResourceNotFoundException;

    void addPhoneToName(String name, String phone) throws ResourceNotFoundException;

    void addRecord(String name, Set<String> phones);

    void removeRecord(String name) throws ResourceNotFoundException;
}
