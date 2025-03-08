package com.AddressBookApp.Interface;
import com.AddressBookApp.DTO.AuthUserDTO;
import com.AddressBookApp.Model.AuthUser;
public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;

}