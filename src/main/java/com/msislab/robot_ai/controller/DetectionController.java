package com.msislab.robot_ai.controller;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.msislab.robot_ai.model.Detection;
import com.msislab.robot_ai.service.DetectionService;




@RestController
@RequestMapping("/detections")
public class DetectionController {

    private DetectionService detectionService;

    // POST endpoint to create a new detection
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Detection createDetection(@RequestBody Detection detection) {
        return detectionService.createDetection(detection);
    }
}

