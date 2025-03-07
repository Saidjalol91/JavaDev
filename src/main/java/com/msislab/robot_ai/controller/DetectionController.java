package com.msislab.robot_ai.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.msislab.robot_ai.util.*;


@RestController
@RequestMapping(Const.baseUrl)
public class DetectionController {

    @GetMapping("/")
    public String getMethodName() {
        return "Hello Detections API";
    }
    
    
}
