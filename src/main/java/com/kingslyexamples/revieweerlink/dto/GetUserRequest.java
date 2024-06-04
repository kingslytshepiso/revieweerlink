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

}
