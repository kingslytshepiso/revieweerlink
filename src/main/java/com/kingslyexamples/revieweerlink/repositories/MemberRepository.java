package com.kingslyexamples.revieweerlink.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingslyexamples.revieweerlink.models.Member;

public interface MemberRepository extends JpaRepository<Member, UUID> {

}
