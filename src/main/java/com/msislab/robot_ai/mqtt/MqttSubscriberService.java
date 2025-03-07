package com.msislab.robot_ai.mqtt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msislab.robot_ai.model.Detection;
import com.msislab.robot_ai.service.DetectionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MqttSubscriberService {

    private final MqttClient mqttClient;
    private final DetectionService detectionService;

    @Value("${mqtt.topic}")
    private String topic;

    @Value("${mqtt.qos}")
    private int qos;

    // public MqttSubscriberService(MqttClient mqttClient) {
    //     this.mqttClient = mqttClient;
    // }



private LocalDateTime parseTimestamp(String ts) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    return LocalDateTime.parse(ts, formatter);
}


    @PostConstruct
    public void subscribe() {
        try {
            mqttClient.subscribe(topic, qos, this::handleMessage);
            System.out.println("Subscribed to topic: " + topic);
        } catch (MqttException e) {
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    private void handleMessage(String topic, MqttMessage message) {
    String payload = new String(message.getPayload());
    System.out.println("Received message on topic " + topic + ": " + payload);
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        MqttMessagePayload mqttPayload = objectMapper.readValue(payload, MqttMessagePayload.class);

        List<Detection> detections = new ArrayList<>();
        Map<String, Boolean> modelResults = mqttPayload.getModelResults();
        
        for (Map.Entry<String, Boolean> entry : modelResults.entrySet()) {
            String modelName = entry.getKey();
            Boolean defectStatus = entry.getValue();

            Detection detection = new Detection();
            detection.setProductId(mqttPayload.getConnectorId());
            detection.setMachineId(mqttPayload.getMachine());
            detection.setModel(modelName);  // Set model name
            detection.setStatus(defectStatus ? "Defective" : "OK"); // Set status based on defect
            detection.setTimestamp(parseTimestamp(mqttPayload.getTs())); // Convert timestamp
            
            // detections.add(detection);
        }

        detectionService.createDetectionList(detections);
        
    } catch (JsonProcessingException e) {
        System.err.println("Error parsing MQTT message: " + e.getMessage());
    }
}
}
