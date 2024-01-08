package com.francisca.verificationService.service;

import com.francisca.verificationService.response.CardStatsResponse;
import com.francisca.verificationService.response.CardVerificationResponse;

public interface CardVerificationService {
    CardVerificationResponse verifyCard(String cardNumber);

  //  CardStatsResponse getCardStats(int start, int limit);

}
