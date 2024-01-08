package com.francisca.verificationService.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor

public class Payload {
    private String scheme;
    private String type;
    private String bank;
}
