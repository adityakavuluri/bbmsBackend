package com.bloodBank.bbms.bbmsbackend.controller;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
@Autowired
private UserService userService;
    @PostMapping(path = "/user/save")
    public String saveUser(@RequestBody SignUpDto signUpDto)
    {
        String id = userService.addUser(signUpDto);
        return id;
    }

    @PostMapping(path = "/user/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
    @PostMapping(path = "/admin/login")
    public ResponseEntity<?> loginadmin(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        System.out.println("NewOne"+loginResponse.getMessage());

        return ResponseEntity.ok(loginResponse);
    }
    @GetMapping(path = "/test")
    public String demo(){

        return "Hi";
    }
}