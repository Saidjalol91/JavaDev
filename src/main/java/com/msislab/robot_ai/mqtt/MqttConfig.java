package com.msislab.robot_ai.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.client.id}")
    private String clientId;


    @Value("${mqtt.client.timeout}")
    private Integer timeout;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient client = new MqttClient(brokerUrl, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        
        options.setAutomaticReconnect(true);
        options.setCleanSession(false);
        options.setConnectionTimeout(timeout);
        
        try {
            client.connect(options);
            System.out.println("Connected to MQTT broker: " + brokerUrl);
        } catch (MqttException e) {
            System.err.println("Failed to connect to MQTT broker: " + e.getMessage());
        }
    
        return client;
    }
}
