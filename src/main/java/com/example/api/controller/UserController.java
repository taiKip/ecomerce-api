package com.example.api.controller;

import com.example.api.entity.User;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> fetchUsers(){
        return  userService.fetchUsers();
    }

    @GetMapping(path = "/{userId}")
    public User findUserById(@PathVariable("userId") Long userId){
        return userService.findUserById(userId);
    }
}
