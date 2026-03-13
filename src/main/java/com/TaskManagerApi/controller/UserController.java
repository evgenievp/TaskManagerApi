package com.TaskManagerApi.controller;

import com.TaskManagerApi.dto.UserDto;
import com.TaskManagerApi.model.User;
import com.TaskManagerApi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto dto) {
        UserDto user = this.userService.register(dto);
        return ResponseEntity.status(201).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto user) {
        UserDto userDto = this.userService.login(user);
        return ResponseEntity.status(200).body(userDto);
    }


}
