package com.AddressBookApp.Service;

import com.AddressBookApp.DTO.AddressBookDTO;
import com.AddressBookApp.Interface.AddressBookServiceInterface;
import com.AddressBookApp.Model.AddressBookModel;
import com.AddressBookApp.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService implements AddressBookServiceInterface {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<AddressBookDTO> getAllContacts(){
        return addressRepository.findAll().stream()
                .map(contact -> new AddressBookDTO(contact.getId(), contact.getName(), contact.getPhone()))
                .collect(Collectors.toList());
    }
    @Override
    public AddressBookDTO saveContact(AddressBookDTO addressBookDTO) {
        AddressBookModel contact = new AddressBookModel();
        contact.setName(addressBookDTO.getName());
        contact.setPhone(addressBookDTO.getPhone());
        AddressBookModel savedContact = addressRepository.save(contact);
        return new AddressBookDTO(savedContact.getId(), savedContact.getName(), savedContact.getPhone());
    }
}
