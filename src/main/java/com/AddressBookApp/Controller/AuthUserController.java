package com.AddressBookApp.Controller;

import com.AddressBookApp.DTO.AuthUserDTO;
import com.AddressBookApp.DTO.ResponseDTO;
import com.AddressBookApp.Model.AuthUser;
import com.AddressBookApp.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthUserController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> resgister(@Valid @RequestBody AuthUserDTO userDTO) throws Exception{
        AuthUser user = authenticationService.register(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User details submitted!", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
