package com.AddressBookApp.Controller;

import com.AddressBookApp.DTO.AddressBookDTO;
import com.AddressBookApp.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;
    @GetMapping("/show")
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }
    @PostMapping
    public ResponseEntity<AddressBookDTO> addContact(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok(addressBookService.saveContact(addressBookDTO));
    }
}
