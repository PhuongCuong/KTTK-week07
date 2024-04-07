package com.example.cau_2.services;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service

public class SubjectService {
//    @Retryable(maxAttempts=5, value = RuntimeException.class,
//            backoff = @Backoff(delay = 2000, multiplier = 2))
    public ResponseEntity<String> getSubService(Long id) {
        System.out.println("check log");
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8081/cau1/get-sub?id="+id;
        String response
                = restTemplate.getForObject(fooResourceUrl, String.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
