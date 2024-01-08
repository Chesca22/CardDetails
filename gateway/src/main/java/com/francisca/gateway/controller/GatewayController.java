package com.francisca.gateway.controller;

import com.francisca.verificationService.response.CardStatsResponse;
import com.francisca.verificationService.response.CardVerificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class GatewayController {

        private final WebClient webClient;



        @GetMapping("/card-scheme/verify/{cardNumber}")
        public ResponseEntity<CardVerificationResponse> verifyCard(@PathVariable String cardNumber) {
            // Forward request to Card Verification Service
            CardVerificationResponse response = webClient.get()
                    .uri("http://card-verification-service/verify/" + cardNumber)
                    .retrieve()
                    .bodyToMono(CardVerificationResponse.class)
                    .block();

            return ResponseEntity.ok(response);
        }

        @GetMapping("/card-scheme/stats")
        public ResponseEntity<CardStatsResponse> getCardStats(@RequestParam int start, @RequestParam int limit) {
            // Forward request to Card Stats Service
            CardStatsResponse response = webClient.get()
                    .uri("http://card-stats-service/stats?start=" + start + "&limit=" + limit)
                    .retrieve()
                    .bodyToMono(CardStatsResponse.class)
                    .block();

            return ResponseEntity.ok(response);
        }


}
