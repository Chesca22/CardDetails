package com.francisca.verificationService.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.francisca.verificationService.model.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@lombok.Data

@AllArgsConstructor
@NoArgsConstructor
public class CardVerificationResponse {
    @JsonProperty("scheme")
    private String scheme;
   @JsonProperty("type")
    private String type;
    @JsonProperty("bank")
    private Bank bank;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Bank {
        private String name;
    }
}
