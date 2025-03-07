package com.msislab.robot_ai.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.msislab.robot_ai.model.Detection;

public interface DetectionRepository extends JpaRepository<Detection, Long> {
    
} 
