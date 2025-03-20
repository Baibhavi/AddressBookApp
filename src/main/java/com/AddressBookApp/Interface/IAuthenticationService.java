package com.AddressBookApp.Interface;
import com.AddressBookApp.DTO.AuthUserDTO;
import com.AddressBookApp.DTO.LoginDTO;
import com.AddressBookApp.Model.AuthUser;
import jakarta.servlet.http.HttpServletResponse;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    public String login(LoginDTO user, HttpServletResponse response);
    String forgotPassword(String email, String newPassword);
    String resetPassword(String email, String currentPassword, String newPassword);
}