package com.AddressBookApp.Interface;

import com.AddressBookApp.DTO.AddressBookDTO;
import java.util.List;

public interface AddressBookServiceInterface {
    List<AddressBookDTO> getAllContacts();
    AddressBookDTO saveContact(AddressBookDTO dto);
}
