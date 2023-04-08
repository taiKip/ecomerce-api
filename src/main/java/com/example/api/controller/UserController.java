package com.example.api.controller;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//admin routes

    @GetMapping(path = "users/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }
//@desc current user
    @PutMapping(path = "profile")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user ) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
