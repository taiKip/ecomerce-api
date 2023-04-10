package com.example.api.service;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserService {


    List<UserDTO> fetchUsers();

    UserDTO findUserById(Long userId);

    User fetchUserByEmail(String userEmail);

    UserDTO updateUser(User user);

    String banUser(Long userId);


   // Page<UserDTO> fetchUsersByPage(int pageNumber, int pageSize);
}
