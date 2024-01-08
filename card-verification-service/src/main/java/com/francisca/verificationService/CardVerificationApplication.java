package com.francisca.verificationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CardVerificationApplication {

           public static void main(String[] args) {
            SpringApplication.run(CardVerificationApplication.class, args);
        }


}
