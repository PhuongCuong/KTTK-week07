package com.example.cau_1.controller;

import com.example.cau_1.models.Subject;
import com.example.cau_1.responsitory.SubjectResponsitory;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("cau1")
public class SubjectController {
    @Autowired
    private SubjectResponsitory subjectResponsitory;

//    public SubjectController() {
//        Bandwidth limit = Bandwidth.classic(2, Refill.greedy(2, Duration.ofMinutes(1)));
//        this.bucket = Bucket.builder()
//                .addLimit(limit)
//                .build();
//    }


    @PostMapping(value = "/create-sub", consumes = "application/json")
    public ResponseEntity<String> createSub(@RequestBody Subject user) {
        subjectResponsitory.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");
    }

    @GetMapping(value = "/get-sub")
    public Subject getSub(Long id) {
        return subjectResponsitory.findSubjectBySubId(id).get();
    }

}
