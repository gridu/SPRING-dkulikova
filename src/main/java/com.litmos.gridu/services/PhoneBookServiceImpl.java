package com.litmos.gridu.services;

import com.litmos.gridu.DTOs.PhoneBookRecordDTO;
import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class PhoneBookServiceImpl implements PhoneBookService {
    @Autowired
    private InMemoryRepository dataBase;

    @Override
    public List<PhoneBookRecordDTO> findAll() {
        List<PhoneBookRecordDTO> list = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : dataBase.findAll().entrySet())
            list.add(new PhoneBookRecordDTO(entry.getKey(),entry.getValue()));

        return list;
    }

    @Override
    public PhoneBookRecordDTO findAllPhonesByName(String name) throws ResourceNotFoundException {
        return new PhoneBookRecordDTO(name, dataBase.findAllPhonesByName(name));
    }

    @Override
    public PhoneBookRecordDTO addPhoneToName(String name, String phone) throws ResourceNotFoundException {
        dataBase.addPhoneToName(name,phone);
        return new PhoneBookRecordDTO(name, dataBase.findAllPhonesByName(name));

    }

    @Override
    public PhoneBookRecordDTO addRecord(PhoneBookRecordDTO phoneBookRecordDTO) {
        dataBase.addRecord(phoneBookRecordDTO.getName(),phoneBookRecordDTO.getPhones());
        return phoneBookRecordDTO;
    }

    @Override
    public void removeRecord(String name) throws ResourceNotFoundException {
        dataBase.removeRecord(name);
    }
}
