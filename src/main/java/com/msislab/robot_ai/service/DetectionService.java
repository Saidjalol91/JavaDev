package com.msislab.robot_ai.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msislab.robot_ai.model.Detection;
import com.msislab.robot_ai.repository.DetectionRepository;

@Service
public class DetectionService {

   @Autowired
   
    private final DetectionRepository detectionRepository;

    public DetectionService(DetectionRepository detectionRepository) {
        this.detectionRepository = detectionRepository;
    }

    public Detection createDetection(Detection detection) {
        // Format timestamp
        String rawTimestamp = detection.getTimestamp().toString();
        String formattedTimestamp = rawTimestamp.replace("T", " ").replace("Z", "");
        detection.setTimestamp(LocalDateTime.parse(formattedTimestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return detectionRepository.save(detection);
    }
    
}
