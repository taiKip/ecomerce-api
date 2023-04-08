package com.example.api.service;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    List<UserDTO> fetchUsers();

    UserDTO findUserById(Long userId);

    User fetchUserByEmail(String userEmail);

    UserDTO updateUser(User user);

    String banUser(Long userId);

     String activateUser(Long userId);
}
