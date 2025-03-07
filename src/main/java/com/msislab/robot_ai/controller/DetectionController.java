package com.msislab.robot_ai.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.msislab.robot_ai.model.Detection;





@RestController
@RequestMapping
public class DetectionController { 

    // POST endpoint to create a new detection
    @PostMapping("/detections")
    public ResponseEntity<String> createDetection(@RequestBody Detection detection) {
        return ResponseEntity.ok("successed");
        //return detectionService.createDetection(detection);
    }
}

