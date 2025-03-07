package com.msislab.robot_ai.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.msislab.robot_ai.model.Detection;
import com.msislab.robot_ai.repository.DetectionRepository;

import jakarta.transaction.Transactional;

@Service
public class DetectionService {

   @Autowired
   
    private final DetectionRepository detectionRepository;

    public DetectionService(DetectionRepository detectionRepository) {
        this.detectionRepository = detectionRepository;
    }

    @Transactional
    public ResponseEntity<?> createDetection(Detection detection) {
        // Format timestamp
        // String rawTimestamp = detection.getTimestamp().toString();
        // String formattedTimestamp = rawTimestamp.replace("T", " ").replace("Z", "");
        // detection.setTimestamp(LocalDateTime.parse(formattedTimestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try{
            System.out.println("Detection was saved successfully " + detection.getTimestamp());
            return ResponseEntity.ok(detectionRepository.save(detection));
        }catch(DataIntegrityViolationException ex){
            //pass
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate entry");
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(detectionRepository.findAll());
    }


    @Transactional
    public void createDetectionList(List<Detection> detections){
        try{
            detectionRepository.saveAll(detections);
            System.out.println("Detections were saved successfully ");
        }catch(DataIntegrityViolationException ex){
            //pass
        }
    }
    
}
