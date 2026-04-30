package com.airservepro.airservepro.service;

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

        userRepository.save(newUser);

        return "Registered Successfully";
    }


}
