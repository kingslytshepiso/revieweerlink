package com.kingslyexamples.revieweerlink.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requestOwner;
    @ManyToOne
    @JoinColumn(name = "reviewee_id")
    private User reviewee;
    private boolean isCompleted;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private ReviewRequest reviewRequest;
    // open to possibilities of adding a template and other attributes that may be
    // required for visuals

    public UserRequest() {
    }

    public UserRequest(UUID id, User requestOwner, User reviewee, boolean isCompleted, ReviewRequest reviewRequest) {
        this.id = id;
        this.requestOwner = requestOwner;
        this.reviewee = reviewee;
        this.isCompleted = isCompleted;
        this.reviewRequest = reviewRequest;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getRequestOwner() {
        return requestOwner;
    }

    public void setRequestOwner(User requestOwner) {
        this.requestOwner = requestOwner;
    }

    public User getReviewee() {
        return reviewee;
    }

    public void setReviewee(User reviewee) {
        this.reviewee = reviewee;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public ReviewRequest getReviewRequest() {
        return reviewRequest;
    }

    public void setReviewRequest(ReviewRequest reviewRequest) {
        this.reviewRequest = reviewRequest;
    }

}
