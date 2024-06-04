package com.kingslyexamples.revieweerlink.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kingslyexamples.revieweerlink.models.Member;
import com.kingslyexamples.revieweerlink.models.ReviewGroup;
import com.kingslyexamples.revieweerlink.models.ReviewRequest;
import com.kingslyexamples.revieweerlink.models.StakeholderProperties;
import com.kingslyexamples.revieweerlink.models.User;
import com.kingslyexamples.revieweerlink.models.UserRequest;
import com.kingslyexamples.revieweerlink.repositories.MemberRepository;
import com.kingslyexamples.revieweerlink.repositories.ReviewGroupRepository;
import com.kingslyexamples.revieweerlink.repositories.ReviewRequestRepository;
import com.kingslyexamples.revieweerlink.repositories.StakeholderRepository;
import com.kingslyexamples.revieweerlink.repositories.UserRepository;
import com.kingslyexamples.revieweerlink.repositories.UserRequestRepository;

@RestController
@RequestMapping("api/review-requests")
public class ReviewRequestController {
    @Autowired
    public ReviewRequestRepository reviewRequestRepository;
    @Autowired
    public ReviewGroupRepository reviewGroupRepository;
    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public StakeholderRepository stakeholderRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserRequestRepository userRequestRepository;

    @GetMapping
    public ResponseEntity<List<ReviewRequest>> getAll() {
        return ResponseEntity.ok(reviewRequestRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ReviewRequest model) {
        return ResponseEntity.ok(reviewRequestRepository.save(model));
    }

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestParam UUID id) {
        // operations to save the request for each user
        Optional<ReviewRequest> possibleReviewRequest = reviewRequestRepository.findById(id);
        if (possibleReviewRequest.isPresent()) {
            ReviewRequest currentReviewRequest = possibleReviewRequest.get();
            for (ReviewGroup group : currentReviewRequest.getReviewGroups()) {
                if (group.isCanReviewEachOther()) {
                    for (Member member : group.getMembers()) {
                        Optional<User> possibleUser = userRepository.findByEmail(member.getEmail());
                        if (possibleUser.isEmpty()) {
                            User createdUser = createUser(member.getFirstName(), member.getLastName(),
                                    member.getEmail(), UUID.randomUUID().toString());
                            resolveUserRequests(createdUser, group.getMembers(), currentReviewRequest);
                        } else {
                            User user = possibleUser.get();
                            resolveUserRequests(user, group.getMembers(), currentReviewRequest);
                        }
                        sendEmail(member.getFirstName(), member.getEmail());
                    }
                }
                for (StakeholderProperties stakeholder : group.getStakeholders()) {
                    if (stakeholder.isCanBeReviewed()) {
                        sendEmail(stakeholder.getFirstName(), stakeholder.getEmail());
                    }
                    if (stakeholder.isCanReview()) {
                        sendEmail(stakeholder.getFirstName(), stakeholder.getEmail());
                    }
                }
            }
            return ResponseEntity.ok().build();
        }
        // operations to send the emails

        // update review request status

        return ResponseEntity.notFound().build();
    }

    private User createUser(String firstName, String lastName, String email, String emailToken) {
        User user = new User(null, firstName, lastName, email, emailToken, null);
        return userRepository.save(user);
    }

    private void sendEmail(String name, String email) {
        // email sending operations
    }

    private void resolveUserRequests(User requestOwner, Set<Member> otherMembers, ReviewRequest request) {
        for (Member otherMember : otherMembers) {
            if (!(otherMember.getEmail().equals(requestOwner.getEmail()))) {
                Optional<User> possibleOtherUser = userRepository.findByEmail(otherMember.getEmail());
                if (possibleOtherUser.isEmpty()) {
                    User createdOtherUser = createUser(otherMember.getFirstName(), otherMember.getLastName(),
                            otherMember.getEmail(), null);
                    createUserRequest(requestOwner, createdOtherUser, request);
                } else {
                    User otherUser = possibleOtherUser.get();
                    createUserRequest(requestOwner, otherUser, request);
                }
            }
        }
    }

    private UserRequest createUserRequest(User requestOwner, User reviewee, ReviewRequest request) {
        UserRequest userRequest = new UserRequest(null, requestOwner, reviewee, false, request);
        return userRequestRepository.save(userRequest);
    }

}
