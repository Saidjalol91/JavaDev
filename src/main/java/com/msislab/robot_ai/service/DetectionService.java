package com.msislab.robot_ai.service;

import java.util.List;

import com.msislab.robot_ai.model.Detection;

public interface DetectionService {

    Integer createDetectionList(List<Detection> detections);

    Detection create(Detection detection);
    
}
