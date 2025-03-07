package com.msislab.robot_ai.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mqtt_client_state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MqttClientState {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private final String status = "AVAIL";
    
    @Column(nullable = false)
    private final LocalDateTime lastUpdated = LocalDateTime.now();
}

