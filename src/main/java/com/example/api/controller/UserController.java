package com.example.api.controller;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    /**
     * @desc View user
     * @route Get
     * @access Private - Admin
     */
    @GetMapping(path = "{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }
    /**
     * @desc View profile
     * @route Get
     * @access current user
     */
    @PutMapping(path = "profile")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user , @RequestParam("image") MultipartFile file) {
        return ResponseEntity.ok(userService.updateUser(user,file));
    }

}
