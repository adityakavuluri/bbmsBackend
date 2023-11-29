package com.bloodBank.bbms.bbmsbackend.service;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;

public interface UserService {
     String addUser(SignUpDto signUpDto);
     LoginResponse loginUser(LoginDto loginDto);

}