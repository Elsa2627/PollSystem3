package com.yourcompany.pollservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PollserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PollserviceApplication.class, args);
    }


    private static class PollServiceApplication {
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}



