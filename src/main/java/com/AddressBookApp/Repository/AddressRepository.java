package com.AddressBookApp.Repository;

import com.AddressBookApp.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressBookModel,Long> {
}
