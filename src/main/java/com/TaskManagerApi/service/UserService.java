package com.TaskManagerApi.service;

import com.TaskManagerApi.dto.UserDto;
import com.TaskManagerApi.model.User;
import com.TaskManagerApi.repo.UserRepo;

public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    // shall fix register and login later
//    public UserDto register(UserDto dto) {
//        this.userRepo.save(toUser(dto));
//        return dto;
//    }
//
//    public String login(UserDto dto) {
//        User user = userRepo.findByEmail(dto.getEmail())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        if (!passwordEncoder.matches(dto.getEmail(), user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//        return "jwt";
//    }

    public User toUser(UserDto dto) {
        return new User(
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword()
        );
    }

    public UserDto toDto(User user) {
        return new UserDto(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
