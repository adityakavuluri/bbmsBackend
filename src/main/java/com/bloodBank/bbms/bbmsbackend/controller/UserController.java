package com.bloodBank.bbms.bbmsbackend.controller;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.service.UserService;
import com.bloodBank.bbms.bbmsbackend.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {
@Autowired
private UserService userService;
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody SignUpDto signUpDto)
    {
        String id = userService.addUser(signUpDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}