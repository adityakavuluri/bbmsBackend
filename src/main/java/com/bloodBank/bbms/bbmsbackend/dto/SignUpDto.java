package com.bloodBank.bbms.bbmsbackend.dto;

import lombok.Data;
@Data
public class SignUpDto {

    private Integer id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String country;

    private Integer pincode;

    private String phone;

    private String medicalHistory;

    private String bloodGroup;

    private Integer age;

    private String sex;
}
