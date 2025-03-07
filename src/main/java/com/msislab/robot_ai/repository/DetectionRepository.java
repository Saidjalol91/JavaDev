package com.msislab.robot_ai.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msislab.robot_ai.model.Detection;

@Repository
public interface DetectionRepository extends JpaRepository<Detection, Long> {
    
} 
