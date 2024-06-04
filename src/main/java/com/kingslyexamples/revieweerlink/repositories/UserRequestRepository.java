package com.kingslyexamples.revieweerlink.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingslyexamples.revieweerlink.models.User;
import com.kingslyexamples.revieweerlink.models.UserRequest;

public interface UserRequestRepository extends JpaRepository<UserRequest, UUID> {
    List<UserRequest> findAllByRequestOwner(User requestOwner);
}
