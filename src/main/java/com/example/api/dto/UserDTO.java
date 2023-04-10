package com.example.api.dto;

public record UserDTO (
        Long id,
        String firstname,
        String lastname,
        String email,
        boolean isBanned
) {


}
