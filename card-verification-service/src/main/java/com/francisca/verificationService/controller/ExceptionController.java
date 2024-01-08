package com.francisca.verificationService.controller;

import com.francisca.verificationService.exception.CardVerificationException;
import com.francisca.verificationService.response.ExceptionResponse;
import com.francisca.verificationService.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
    @RequiredArgsConstructor
    public class ExceptionController {

        private final ResponseService<ExceptionResponse> responseService;

        @ExceptionHandler(CardVerificationException.class)
        public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(CardVerificationException exception){
            return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
        }

    }
