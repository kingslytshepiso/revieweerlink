package com.kingslyexamples.revieweerlink.models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ReviewGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private boolean canReviewEachOther;
    private String template;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "review_group_members", joinColumns = @JoinColumn(name = "review_group_id"), inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Set<Member> members;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "review_group_stakeholder", joinColumns = @JoinColumn(name = "review_group_id"), inverseJoinColumns = @JoinColumn(name = "stakeholder_id"))
    private Set<StakeholderProperties> stakeholders;

    public ReviewGroup() {
    }

    public ReviewGroup(UUID id, String name, boolean canReviewEachOther, String template, Set<Member> members,
            Set<StakeholderProperties> stakeholders) {
        this.id = id;
        this.name = name;
        this.canReviewEachOther = canReviewEachOther;
        this.template = template;
        this.members = members;
        this.stakeholders = stakeholders;
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

    public boolean isCanReviewEachOther() {
        return canReviewEachOther;
    }

    public void setCanReviewEachOther(boolean canReviewEachOther) {
        this.canReviewEachOther = canReviewEachOther;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<StakeholderProperties> getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(Set<StakeholderProperties> stakeholders) {
        this.stakeholders = stakeholders;
    }

}
