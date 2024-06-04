package com.kingslyexamples.revieweerlink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingslyexamples.revieweerlink.models.ReviewGroup;
import com.kingslyexamples.revieweerlink.repositories.ReviewGroupRepository;

@RestController
@RequestMapping("api/review-groups")
public class ReviewGroupController {
    @Autowired
    public ReviewGroupRepository reviewGroupRepository;

    @GetMapping
    public ResponseEntity<List<ReviewGroup>> getAll() {
        return ResponseEntity.ok(reviewGroupRepository.findAll());
    }
}
