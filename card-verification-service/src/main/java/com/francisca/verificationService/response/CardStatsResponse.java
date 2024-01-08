package com.francisca.verificationService.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardStatsResponse {
    private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, String> payload;

}
