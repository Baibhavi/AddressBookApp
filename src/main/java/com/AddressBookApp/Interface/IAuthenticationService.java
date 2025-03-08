package com.AddressBookApp.Interface;
import com.AddressBookApp.DTO.AuthUserDTO;
import com.AddressBookApp.DTO.LoginDTO;
import com.AddressBookApp.Model.AuthUser;
public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO);
    String forgotPassword(String email, String newPassword);
    String resetPassword(String email, String currentPassword, String newPassword);
}