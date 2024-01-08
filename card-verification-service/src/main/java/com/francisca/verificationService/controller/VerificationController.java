package com.francisca.verificationService.controller;

import com.francisca.verificationService.response.CardVerificationResponse;
import com.francisca.verificationService.service.CardVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-scheme")
@RequiredArgsConstructor
public class VerificationController {
    public final CardVerificationService cardVerificationService;

    @GetMapping("/verify/{cardNumber}")
    public ResponseEntity<CardVerificationResponse> verifyCard(@PathVariable("cardNumber") String cardNumber) {
        CardVerificationResponse response = cardVerificationService.verifyCard(cardNumber);
        return ResponseEntity.ok(response);
    }
}
