package com.francisca.statisticservice.model;


        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardVerificationStatsResponse {

    private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, String> payload;

    public CardVerificationStatsResponse(int start, int limit, int totalSize, Object generateMockPayload) {
    }
}
