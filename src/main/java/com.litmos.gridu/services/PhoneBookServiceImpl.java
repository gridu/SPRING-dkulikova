package com.litmos.gridu.services;

import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Record;
import com.litmos.gridu.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhoneBookServiceImpl implements PhoneBookService {
    @Autowired
    private InMemoryRepository dataBase;


    @Override
    public List<Record> findAllRecords() {
        return dataBase.findAllRecords();
    }

    @Override
    public void deleteRecord(String name) throws ResourceNotFoundException {
        dataBase.deleteRecord(name);
    }

    @Override
    public void updatePhone(String name, String newPhone, String oldPhone) throws ResourceNotFoundException {
        dataBase.updatePhone(name, newPhone, oldPhone);
    }

    @Override
    public void addRecord(Record record) {
        dataBase.addRecord(record);
    }

    @Override
    public Record findAllPhonesByName(String name) throws ResourceNotFoundException {
        return dataBase.findAllPhonesByName(name);
    }

    @Override
    public void deletePhone(String name, String phone) throws ResourceNotFoundException {
        dataBase.deletePhone(name, phone);
    }

    @Override
    public void addPhoneToName(String name, String phone) throws ResourceNotFoundException {
        dataBase.addPhoneToName(name,phone);
    }
}
