package com.kingslyexamples.revieweerlink.models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class StakeholderProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String organisation;
    private boolean isInternal;
    private boolean canReview;
    private boolean canBeReviewed;
    @ManyToMany(mappedBy = "stakeholders")
    private Set<ReviewGroup> reviewGroup;
    @ManyToOne
    @JoinColumn(name = "stakeholder_id")
    private Stakeholder stakeholder;

    public StakeholderProperties() {
    }

    public StakeholderProperties(UUID id, String firstName, String lastName, String email, String role,
            String organisation, boolean isInternal, boolean canReview, boolean canBeReviewed,
            Set<ReviewGroup> reviewGroup, Stakeholder stakeholder) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.organisation = organisation;
        this.isInternal = isInternal;
        this.canReview = canReview;
        this.canBeReviewed = canBeReviewed;
        this.reviewGroup = reviewGroup;
        this.stakeholder = stakeholder;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }

    public boolean isCanReview() {
        return canReview;
    }

    public void setCanReview(boolean canReview) {
        this.canReview = canReview;
    }

    public boolean isCanBeReviewed() {
        return canBeReviewed;
    }

    public void setCanBeReviewed(boolean canBeReviewed) {
        this.canBeReviewed = canBeReviewed;
    }

    public Set<ReviewGroup> getReviewGroup() {
        return reviewGroup;
    }

    public void setReviewGroup(Set<ReviewGroup> reviewGroup) {
        this.reviewGroup = reviewGroup;
    }

    public Stakeholder getStakeholder() {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder) {
        this.stakeholder = stakeholder;
    }

}
