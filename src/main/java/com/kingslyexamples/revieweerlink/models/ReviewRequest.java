package com.kingslyexamples.revieweerlink.models;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class ReviewRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToMany
    @JoinTable(name = "review_request_review_group", joinColumns = @JoinColumn(name = "review_request_id"), inverseJoinColumns = @JoinColumn(name = "review_group_id"))
    private Set<ReviewGroup> reviewGroups;
    @OneToMany(mappedBy = "reviewRequest")
    private Set<UserRequest> userRequests;

    public ReviewRequest() {
    }

    public ReviewRequest(UUID id, String name, LocalDate startDate, LocalDate endDate, Set<ReviewGroup> reviewGroups,
            Set<UserRequest> userRequests) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reviewGroups = reviewGroups;
        this.userRequests = userRequests;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate starDate) {
        this.startDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<ReviewGroup> getReviewGroups() {
        return reviewGroups;
    }

    public void setReviewGroups(Set<ReviewGroup> reviewGroups) {
        this.reviewGroups = reviewGroups;
    }

    public Set<UserRequest> getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(Set<UserRequest> userRequests) {
        this.userRequests = userRequests;
    }

}
