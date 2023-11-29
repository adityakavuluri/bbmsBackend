package com.bloodBank.bbms.bbmsbackend.service.serviceImpl;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.entity.User;
import com.bloodBank.bbms.bbmsbackend.repository.UserRepository;
import com.bloodBank.bbms.bbmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(SignUpDto signUpDto) {

        User user = new User(
                signUpDto.getEmail(),
                this.passwordEncoder.encode(signUpDto.getPassword()),
                //signUpDto.getPassword(),
                signUpDto.getFirstName(),
                signUpDto.getLastName(),
                signUpDto.getAddress(),
                signUpDto.getCountry(),
                signUpDto.getPincode(),
                signUpDto.getPhone(),
                signUpDto.getMedicalHistory(),
                signUpDto.getBloodGroup(),
                signUpDto.getAge(),
                signUpDto.getSex()
        );
System.out.println(user.getPassword()+"ram");
        System.out.println(user.getSex()+"ram");

        userRepository.save(user);

        return user.getEmail();
    }
    SignUpDto signUpDto;

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }


    }

}