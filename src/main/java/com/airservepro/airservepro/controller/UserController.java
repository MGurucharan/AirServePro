package com.airservepro.airservepro.controller;


import com.airservepro.airservepro.dto.UserRegisterDTO;
import com.airservepro.airservepro.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/users"))
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegisterDTO userRegisterDTO)
    {
        return userService.registerUser(userRegisterDTO);
    }

}
