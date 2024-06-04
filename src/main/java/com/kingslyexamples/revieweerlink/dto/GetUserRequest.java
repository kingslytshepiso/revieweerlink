package com.kingslyexamples.revieweerlink.dto;

import com.kingslyexamples.revieweerlink.models.User;

public class GetUserRequest {
    public User requestOwner;
    public User reviewee;
    public boolean isCompleted;
    public String reviewRequestName;

    public GetUserRequest() {
    }

    public GetUserRequest(User requestOwner, User reviewee, boolean isCompleted, String reviewRequestName) {
        this.requestOwner = requestOwner;
        this.reviewee = reviewee;
        this.isCompleted = isCompleted;
        this.reviewRequestName = reviewRequestName;
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

    public String getReviewRequestName() {
        return reviewRequestName;
    }

    public void setReviewRequestName(String reviewRequestName) {
        this.reviewRequestName = reviewRequestName;
    }

}
