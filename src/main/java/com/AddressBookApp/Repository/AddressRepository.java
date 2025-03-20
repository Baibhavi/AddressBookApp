package com.AddressBookApp.Repository;

import com.AddressBookApp.Model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressBookModel, Long> {
}
