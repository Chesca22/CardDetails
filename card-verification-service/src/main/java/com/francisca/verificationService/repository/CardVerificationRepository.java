package com.francisca.verificationService.repository;

import com.francisca.verificationService.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardVerificationRepository extends JpaRepository<CardDetails, Long> {
}
