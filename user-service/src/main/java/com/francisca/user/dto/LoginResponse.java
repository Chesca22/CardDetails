package com.francisca.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse{
    private Long id;

    private String username;
    private String email;

    private String secretKey;

    private String accessToken;

    private Date tokenExpirationDate;
}