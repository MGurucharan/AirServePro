package com.airservepro.airservepro.dto;

import com.airservepro.airservepro.enums.Roles;

public record UserRegisterDTO(
    String user,
    String email,
    String password,
    Roles role
) {}
