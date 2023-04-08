package com.example.api.controller;

import com.example.api.dto.UserDTO;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
public class AdminController {
private final UserService userService;
    @GetMapping(path="users")
    public List<UserDTO> fetchUsers() {
        return userService.fetchUsers();
    }
    @PutMapping(path = "{userId}")
    public ResponseEntity<String> banUser(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(userService.banUser(userId));
    }

    @PutMapping(path = "activate/{userId}")
    public  ResponseEntity<String> activateUser(@PathVariable("userId") Long userId){
        return  ResponseEntity.ok(userService.activateUser(userId));
    }

}
