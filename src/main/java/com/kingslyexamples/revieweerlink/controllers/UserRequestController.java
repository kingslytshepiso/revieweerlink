package com.kingslyexamples.revieweerlink.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingslyexamples.revieweerlink.dto.GetUserRequest;
import com.kingslyexamples.revieweerlink.models.User;
import com.kingslyexamples.revieweerlink.models.UserRequest;
import com.kingslyexamples.revieweerlink.repositories.UserRepository;
import com.kingslyexamples.revieweerlink.repositories.UserRequestRepository;

@RestController
@RequestMapping("api/user-requests")
public class UserRequestController {
    @Autowired
    public UserRequestRepository userRequestRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<GetUserRequest>> getAll() {
        List<UserRequest> allRequests = userRequestRepository.findAll();
        List<GetUserRequest> returnData = new ArrayList<>();
        for (UserRequest u : allRequests) {
            GetUserRequest userRequest = new GetUserRequest(u.getRequestOwner(), u.getReviewee(), u.isCompleted(),
                    u.getReviewRequest().getName());
            returnData.add(userRequest);
        }
        return ResponseEntity.ok(returnData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserRequest>> getAllById(@PathVariable("id") UUID id) {
        Optional<User> possibleUser = userRepository.findById(id);
        if (possibleUser.isPresent()) {
            return ResponseEntity.ok(userRequestRepository.findAllByRequestOwner(possibleUser.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
