package com.litmos.gridu.controllers.rest;

import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Record;
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
    public List<Record> listRecords() {
        return phoneBookService.findAllRecords();
    }

    @GetMapping("/record/{name}")
    @ResponseBody
    public Record findPhonesByName(@PathVariable String name) throws ResourceNotFoundException {
        return phoneBookService.findAllPhonesByName(name);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/record/{name}/{phone}")
    @ResponseBody
    public void addPhoneToName(@PathVariable String name, @PathVariable String phone) throws ResourceNotFoundException{
        phoneBookService.addPhoneToName(name,phone);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/record")
    @ResponseBody
    public void addRecord(@RequestBody Record record) {
        phoneBookService.addRecord(record);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/record/{name}")
    @ResponseBody
    public void deleteRecord(@PathVariable String name) throws ResourceNotFoundException{
        phoneBookService.deleteRecord(name);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/record/{name}/{phone}")
    @ResponseBody
    public void deleteRecord(@PathVariable String name, @PathVariable String phone) throws ResourceNotFoundException{
        phoneBookService.deletePhone(name, phone);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/record/{name}/{newphone}/{oldphone}")
    @ResponseBody
    public void updatePhone(@PathVariable String name, @PathVariable String newPhone, @PathVariable String oldPhone) throws ResourceNotFoundException{
        phoneBookService.updatePhone(name, newPhone, oldPhone);
    }
}
