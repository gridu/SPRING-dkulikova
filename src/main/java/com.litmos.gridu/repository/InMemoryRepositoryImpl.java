package com.litmos.gridu.repository;

import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Record;
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
    public Record findAllPhonesByName(String name) throws ResourceNotFoundException {
        if (data.containsKey(name)){
            return new Record(name,data.get(name));
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void deletePhone(String name, String phone) throws ResourceNotFoundException {
        if (data.containsKey(name)){
            data.get(name).remove(phone);
            if (data.get(name).isEmpty()){
                deleteRecord(name);
            }
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
    public List<Record> findAllRecords() {
        List<Record> records = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : data.entrySet()) {
            records.add(new Record(entry.getKey(), entry.getValue()));
        }
        return records;
    }

    @Override
    public void deleteRecord(String name) throws ResourceNotFoundException {
        if (data.containsKey(name)) {
            data.remove(name);
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void updatePhone(String name, String newPhone, String oldPhone) throws ResourceNotFoundException {
        if (data.containsKey(name)) {
            data.get(name).remove(oldPhone);
            data.get(name).add(newPhone);
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void addRecord(Record record){
        data.put(record.getName(), record.getPhones());
    }
}
