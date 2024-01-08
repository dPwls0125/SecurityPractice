package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public ResponseEntity<?> join(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        userService.signUp(user);
        return new ResponseEntity<>("success",null);
    }
}
