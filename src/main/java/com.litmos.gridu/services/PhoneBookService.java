package com.litmos.gridu.services;

import com.litmos.gridu.DTOs.PhoneBookRecordDTO;
import com.litmos.gridu.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PhoneBookService {

    List<PhoneBookRecordDTO> findAll();

    PhoneBookRecordDTO findAllPhonesByName(String name) throws ResourceNotFoundException;

    PhoneBookRecordDTO addPhoneToName(String name, String phone) throws ResourceNotFoundException;

    PhoneBookRecordDTO addRecord(PhoneBookRecordDTO phoneBookRecordDTO);

    void removeRecord(String name) throws ResourceNotFoundException;
}
