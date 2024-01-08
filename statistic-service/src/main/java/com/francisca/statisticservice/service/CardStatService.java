package com.francisca.statisticservice.service;

import com.francisca.statisticservice.model.CardVerificationStatsResponse;

public interface CardStatService {
    CardVerificationStatsResponse getStats(int start, int limit);
}
