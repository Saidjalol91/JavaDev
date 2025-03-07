package com.msislab.robot_ai.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Detection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Detection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String machineId;
    
    @Column(nullable = false)
    private Integer productId;
    
    @ManyToOne
    @JoinColumn(name = "surface_id", nullable = false)
    private CommonType surface;
    
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private CommonType model;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private CommonType status;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    @Column(nullable = false)
    private Integer inspectionTime;
    
    @Column(nullable = false)
    private String imageUrl;
    
    private String remark;
}
