package com.airservepro.airservepro.service;

import com.airservepro.airservepro.dto.UserLoginDTO;
import com.airservepro.airservepro.dto.UserRegisterDTO;
import com.airservepro.airservepro.model.Users;
import com.airservepro.airservepro.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(@RequestBody UserRegisterDTO userRegisterDTO)
    {
        Users newUser = new Users();
        newUser.setName(userRegisterDTO.user());
        newUser.setPassword(userRegisterDTO.password());
        newUser.setEmail(userRegisterDTO.email());
        newUser.setRole(userRegisterDTO.role());
        userRepository.save(newUser);
        return "Registered Successfully";
    }

    public String loginUser(@RequestBody UserLoginDTO userLoginDTO)
    {
        // Verify the credentials ( email and password )
        // Find user record by email first
        Users user=userRepository.findByEmail(userLoginDTO.email()).orElseThrow(()->new RuntimeException(String.format("User with email %s not found",userLoginDTO.email())));

        // Get the email

        String password=user.getPassword();

        if(password.equals(userLoginDTO.password())) {
            return "Logged in successfully";
        }
        else
        {
            return "Invalid Credentials";
        }
    }
}
