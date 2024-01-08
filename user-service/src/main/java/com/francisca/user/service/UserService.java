package com.francisca.user.service;

import com.francisca.user.dto.LoginRequest;
import com.francisca.user.dto.LoginResponse;
import com.francisca.user.dto.UserRequest;
import com.francisca.user.dto.UserResponse;
import com.francisca.user.exception.UserVerificationException;

import java.util.List;

public interface UserService {

        UserResponse registerUser(UserRequest userRequest) throws Exception;

        LoginResponse loginUser(LoginRequest loginRequest) throws UserVerificationException;

    }
