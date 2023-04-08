package com.example.api.utils;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(user.getId(),
                user.getFirstname(), user.getLastname(), user.getEmail(), user.isBanned());

    }
}
