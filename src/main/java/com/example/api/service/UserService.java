package com.example.api.service;

import com.example.api.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    List<User> fetchUsers();

    User findUserById(Long userId);

    User fetchUserByEmail(String userEmail);
}
