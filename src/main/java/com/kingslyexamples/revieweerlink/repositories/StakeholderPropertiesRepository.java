package com.kingslyexamples.revieweerlink.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingslyexamples.revieweerlink.models.StakeholderProperties;

public interface StakeholderPropertiesRepository extends JpaRepository<StakeholderProperties, UUID> {

}
