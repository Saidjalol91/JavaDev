package com.msislab.robot_ai.controller;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> origin/main
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.msislab.robot_ai.model.Detection;
import com.msislab.robot_ai.repository.DetectionRepository;



@RestController
@RequestMapping("/detections") 
public class DetectionController { 
    
    @Autowired
    private DetectionRepository detectionRepository;

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<Detection> createDetection(@RequestBody Detection detection) {
        //detection.setTimestamp(LocalDateTime.now());
        Detection savedDetection = detectionRepository.save(detection);
        return ResponseEntity.ok(savedDetection);
=======
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createDetection(@RequestBody Detection detection) {
        return detectionService.createDetection(detection);
>>>>>>> origin/main
    }


    @GetMapping
    public ResponseEntity<?> getDetections() {
        return detectionService.findAll();
    }
    
}

