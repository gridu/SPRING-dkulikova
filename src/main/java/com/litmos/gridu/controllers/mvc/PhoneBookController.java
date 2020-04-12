package com.litmos.gridu.controllers.mvc;

import com.litmos.gridu.DTOs.PhoneBookRecordDTO;
import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Phone;
import com.litmos.gridu.models.Record;
import com.litmos.gridu.services.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller("mvc")
@RequestMapping("/phonebook")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping("records")
    public String listRecords(Model model) {
        model.addAttribute("records",phoneBookService.findAll());
        return "records";
    }

    @GetMapping("delete")
    public String deleteRecord (@RequestParam("name") String name) throws ResourceNotFoundException {
        phoneBookService.removeRecord(name);
        return "redirect:/phonebook/records";
    }

    @PostMapping("/addphone")
    public String addPhone (@ModelAttribute("record")Record record) throws ResourceNotFoundException {
        phoneBookService.addPhoneToName(record.getName(),record.getPhone());
        return "redirect:/phonebook/records";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Record record = new Record();
        theModel.addAttribute("record", record);
        return "record-form";
    }

    @GetMapping("/showPhoneFrom")
    public String showPhoneForm(@RequestParam("name") String name,
                                Model theModel) {
        Record record = new Record();
        record.setName(name);
        theModel.addAttribute("record", record);
        return "phone-form";
    }

    @PostMapping("/addrecord")
    public String newPhoneBookRecord(@ModelAttribute("record")Record record) {
        Set<String> set = new HashSet<>();
        set.add(record.getPhone());
        phoneBookService.addRecord(new PhoneBookRecordDTO(record.getName(), set));
        return "redirect:/phonebook/records";
    }
}