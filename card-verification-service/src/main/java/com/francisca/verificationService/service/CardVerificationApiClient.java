package com.francisca.verificationService.service;

import com.francisca.verificationService.exception.CardVerificationException;
import com.francisca.verificationService.response.CardVerificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
public class CardVerificationApiClient {
    private final  WebClient webClient;

    @Value("${api.url}")
    private String url;

    public CardVerificationResponse verifyCard(String cardNumber) {

        try {
            String apiUrl = url + cardNumber;
            return webClient.get()
                    .uri(apiUrl)
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .retrieve()
                    .bodyToMono(CardVerificationResponse.class)
                    .block();
        } catch (Exception e) {
            throw new CardVerificationException("Error calling third-party API", e);
        }
    }
}
