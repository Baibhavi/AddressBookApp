package com.AddressBookApp.Controller;

import com.AddressBookApp.DTO.*;
import com.AddressBookApp.Interface.IAuthenticationService;
import com.AddressBookApp.Model.AuthUser;
import jakarta.persistence.Column;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController

public class AuthUserController {
    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody AuthUserDTO userDTO) throws Exception {
        AuthUser user = authenticationService.register(userDTO);
        ResponseDTO responseUserDTO = new ResponseDTO("User details submitted!", user);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }
    @PostMapping(path ="/login")
    public String login(@Valid @RequestBody LoginDTO user, HttpServletResponse response){
        return authenticationService.login(user, response);
    }

    @PutMapping("/forgotPassword/{email}")
    public ResponseEntity<ResponseDTO> forgotPassword(@PathVariable String email,
                                                      @Valid @RequestBody ForgetPasswordDTO forgotPasswordDTO) {
        String responseMessage = authenticationService.forgotPassword(email, forgotPasswordDTO.getPassword());
        ResponseDTO responseDTO = new ResponseDTO(responseMessage, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/resetPassword/{email}")
    public ResponseEntity<ResponseDTO> resetPassword(@PathVariable String email,
                                                     @Valid @RequestBody ResetPasswordDTO resetPasswordDTO) {
        String responseMessage = authenticationService.resetPassword(email,
                resetPasswordDTO.getCurrentPassword(),
                resetPasswordDTO.getNewPassword());
        return new ResponseEntity<>(new ResponseDTO(responseMessage, null), HttpStatus.OK);
    }
}