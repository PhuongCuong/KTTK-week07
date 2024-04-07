package com.example.cau_2.controller;

import com.example.cau_2.models.Subject;
import com.example.cau_2.responsitory.SubjectResponsitory;
import com.example.cau_2.services.SubjectService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@RestController
@RequestMapping("cau2")
@RequiredArgsConstructor
public class SubjectController {
    @Autowired
    private SubjectResponsitory subjectResponsitory;
    @Autowired
    private SubjectService subjectService;

    private final Bucket bucket;

    public SubjectController() {
        Bandwidth limit = Bandwidth.classic(2, Refill.greedy(2, Duration.ofMinutes(1)));
        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }

    @PostMapping(value = "/create-sub", consumes = "application/json")
    public ResponseEntity<String> createSub(@RequestBody Subject user) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8081/cau1/create-sub";
        String response
                = restTemplate.postForObject(fooResourceUrl,user ,String.class);

        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");
    }

    @GetMapping("/get-sub")
    public ResponseEntity<String> getsub(Long id) {
        if(bucket.tryConsume(1)){
            return  subjectService.getSubService(id);
        }else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }

    }


}
