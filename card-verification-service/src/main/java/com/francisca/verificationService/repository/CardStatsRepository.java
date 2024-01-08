package com.francisca.verificationService.repository;

import com.francisca.verificationService.model.CardStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardStatsRepository extends JpaRepository<CardStats, Long> {

    CardStats findByCardNumber(String cardNumber);

    List<CardStats> findAllByOrderByHitsDesc();

}
