package com.example.api.controller;

import com.example.api.dto.UserDTO;
import com.example.api.entity.User;
import com.example.api.service.AwsS3Service;
import com.example.api.service.UserService;
import com.example.api.utils.FileUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FileUploader fileUploader;

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
    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user ) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
    /**
     * @desc Upload profile image to s3 bucket
     * @route  Post
     * @access current user
     */
    @PostMapping(path = "upload")
    public ResponseEntity<Map<String,String>> updateUser(@RequestParam("image") MultipartFile file) {

        return ResponseEntity.ok(fileUploader.uploadFileAndReturnUrl(file));
    }
}
