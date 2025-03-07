package com.msislab.robot_ai.mqtt;


import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class MqttSubscriberService {

    private final MqttClient mqttClient;

    @Value("${mqtt.topic}")
    private String topic;

    @Value("${mqtt.qos}")
    private int qos;

    public MqttSubscriberService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    @PostConstruct
    public void subscribe() {
        try {
            mqttClient.subscribe(topic, qos, this::handleMessage);
            System.out.println("Subscribed to topic: " + topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void handleMessage(String topic, MqttMessage message) {
        String payload = new String(message.getPayload());
        System.out.println("Received message on topic " + topic + ": " + payload);
    }
}
