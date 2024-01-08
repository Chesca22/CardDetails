package com.francisca.statisticservice.controller;


        import com.francisca.statisticservice.model.CardVerificationStatsResponse;
        import com.francisca.statisticservice.service.CardStatService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/card-scheme")
@RequiredArgsConstructor
public class CardStatsController {



    private final CardStatService statisticsService;

    @GetMapping("/stats")
    public ResponseEntity<CardVerificationStatsResponse> getStats(
            @RequestParam int start,
            @RequestParam int limit) {
        CardVerificationStatsResponse response = statisticsService.getStats(start, limit);
        return ResponseEntity.ok(response);
    }
}
