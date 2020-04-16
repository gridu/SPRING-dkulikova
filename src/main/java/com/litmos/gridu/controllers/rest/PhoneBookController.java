package com.litmos.gridu.controllers.rest;

import com.litmos.gridu.DTOs.PhoneBookRecordDTO;
import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.services.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("rest")
@RequestMapping("/api/v1/phonebook")
public class PhoneBookController {
    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping("/records")
    @ResponseBody
    public List<PhoneBookRecordDTO> listRecords() {
        return phoneBookService.findAll();
    }

    @GetMapping("/record/{name}")
    @ResponseBody
    public PhoneBookRecordDTO findPhonesByName(@PathVariable String name) throws ResourceNotFoundException {
        return phoneBookService.findAllPhonesByName(name);
    }

    @PostMapping("/record/{name}/{phone}")
    @ResponseBody
    public PhoneBookRecordDTO addPhoneToName(@PathVariable String name, @PathVariable String phone) throws ResourceNotFoundException{
        return phoneBookService.addPhoneToName(name,phone);
    }
    @PutMapping("/addrecord")
    @ResponseBody
    public PhoneBookRecordDTO newPhoneBookRecord(@RequestBody PhoneBookRecordDTO record) {
        return phoneBookService.addRecord(record);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/record/{name}")
    public void deleteRecord(@PathVariable String name) throws ResourceNotFoundException{
        phoneBookService.removeRecord(name);
    }
}