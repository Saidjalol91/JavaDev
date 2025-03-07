package com.msislab.robot_ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Detection> createDetection(@RequestBody Detection detection) {
        //detection.setTimestamp(LocalDateTime.now());
        Detection savedDetection = detectionRepository.save(detection);
        return ResponseEntity.ok(savedDetection);
    }
}

