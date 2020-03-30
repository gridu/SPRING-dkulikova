package com.litmos.gridu.repository;

import com.litmos.gridu.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class InMemoryRepositoryImpl implements InMemoryRepository {
    private Map<String, Set<String>> data;

    public InMemoryRepositoryImpl() {
        this(new LinkedHashMap<>());
    }

    public InMemoryRepositoryImpl(Map<String, Set<String>> data) {
        this.data = new LinkedHashMap<>(data);
    }

    @Override
    public Map<String, Set<String>> findAll() {
        return new LinkedHashMap<>(this.data);
    }

    @Override
    public Set<String> findAllPhonesByName(String name) throws ResourceNotFoundException {
        if (data.containsKey(name)){
            return data.get(name);
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void addPhoneToName(String name, String phone) throws ResourceNotFoundException {
        if (data.containsKey(name)) {
            data.get(name).add(phone);
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void addRecord(String name, Set<String> phones){
        data.put(name, phones);
    }

    @Override
    public void removeRecord(String name) throws ResourceNotFoundException{
        if (data.containsKey(name)) {
            data.remove(name);
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

}
