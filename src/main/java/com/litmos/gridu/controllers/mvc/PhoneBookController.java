package com.litmos.gridu.controllers.mvc;

import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Form;
import com.litmos.gridu.models.Record;
import com.litmos.gridu.services.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller("mvc")
@RequestMapping("/phonebook")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping("/records")
    public String listRecords(Model model) {
        model.addAttribute("records",phoneBookService.findAllRecords());
        return "records";
    }

    @GetMapping("/deleteRecord/{name}")
    public String deleteRecord (@PathVariable String name) throws ResourceNotFoundException {
        phoneBookService.deleteRecord(name);
        return "redirect:/phonebook/records";
    }

    @PostMapping("/updatePhone")
    public String updatePhone (@ModelAttribute("form")Form form, @ModelAttribute("oldPhone")String oldPhone) throws ResourceNotFoundException {
        phoneBookService.updatePhone(form.getName(), form.getPhone(), oldPhone);
        return "redirect:/phonebook/records";
    }


    @PostMapping("/addRecord")
    public String addRecord (@ModelAttribute("form") Form form) throws ResourceNotFoundException {
        Set<String> phones = new HashSet<String>();
        phones.add(form.getPhone());
        phoneBookService.addRecord(new Record(form.getName(), phones));
        return "redirect:/phonebook/records";
    }

    @GetMapping("/deletePhone/{name}/{phone}")
    public String deletePhone (@PathVariable String name, @PathVariable String phone) throws ResourceNotFoundException {
        phoneBookService.deletePhone(name, phone);
        return "redirect:/phonebook/records";
    }

    @PostMapping("/addPhone")
    public String addPhone (@ModelAttribute("form")Form form) throws ResourceNotFoundException {
        phoneBookService.addPhoneToName(form.getName(), form.getPhone());
        return "redirect:/phonebook/records";
    }

    @GetMapping("/editPhoneForm/{name}/{phone}")
    public String editPhoneForm(@PathVariable String name, @PathVariable String phone,
                                Model theModel) throws ResourceNotFoundException {
        Form form = new Form();
        form.setName(name);
        theModel.addAttribute("form", form);
        theModel.addAttribute("oldPhone", phone);
        return "record-form";
    }

    @GetMapping("/addPhoneForm/{name}")
    public String showRecordForm(@PathVariable String name,
                                 Model theModel) throws ResourceNotFoundException {
        Form form = new Form();
        form.setName(name);
        theModel.addAttribute("form", form);
        return "record-form";
    }

    @GetMapping("/addRecordForm")
    public String addRecordForm() {
        return "record-form";
    }

}