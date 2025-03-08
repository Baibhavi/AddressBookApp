package com.AddressBookApp.Service;
import com.AddressBookApp.DTO.AuthUserDTO;
import com.AddressBookApp.Interface.IAuthenticationService;
import com.AddressBookApp.Repository.AuthenticationRepository;
import com.AddressBookApp.Model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    AuthenticationRepository authUserRepository;

    @Override
    public AuthUser register(AuthUserDTO userDTO) throws Exception {
        AuthUser user = new AuthUser(userDTO);

        authUserRepository.save(user);

        return user;
    }


}