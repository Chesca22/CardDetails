package com.francisca.verificationService.service;

import com.francisca.verificationService.exception.CardVerificationException;
import com.francisca.verificationService.response.CardVerificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardVerificationServiceImpl implements CardVerificationService{
    //private final WebClient webClient;
    //private final CardStatsRepository cardStatsRepository;
    private final CardVerificationApiClient cardVerificationApiClient;
//private final CardVerificationRepository cardVerificationRepository;

    public CardVerificationResponse verifyCard(String cardNumber) {
        try {
            CardVerificationResponse response = cardVerificationApiClient.verifyCard(cardNumber);
          //  saveVerificationToDatabase(cardNumber, response.getPayload());
            return response;
        } catch (Exception e) {
            throw new CardVerificationException("Error verifying card", e);
        }
    }

//    private void saveVerificationToDatabase(String cardNumber, Payload payload) {
//        CardDetails entity = new CardDetails(cardNumber, payload);
//        cardVerificationRepository.save(entity);
//    }
}
