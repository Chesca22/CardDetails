package com.francisca.user.controller;

import com.francisca.user.dto.LoginRequest;
import com.francisca.user.dto.LoginResponse;
import com.francisca.user.dto.UserRequest;
import com.francisca.user.dto.UserResponse;
import com.francisca.user.exception.UserVerificationException;
import com.francisca.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/v1")
    @AllArgsConstructor

    public class AuthController {

        private final UserService userService;

        @PostMapping("/user")
        @ResponseStatus(HttpStatus.CREATED)
        public UserResponse registerUser(@RequestBody UserRequest userRequest)
                throws Exception {
            return userService.registerUser(userRequest);
        }


        @PostMapping("/user/login")
        @ResponseStatus(HttpStatus.OK)
        public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) throws UserVerificationException {
            return userService.loginUser(loginRequest);
        }


    }
