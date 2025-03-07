package com.msislab.robot_ai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "detection",
uniqueConstraints = @UniqueConstraint(columnNames = {"timestamp", "productId", "model", "machineId"}))
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
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "surface_id", nullable = true)
    @JsonIgnore
    private CommonType surface;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    @Column
    private Integer inspectionTime;
    
    @Column
    private String imageUrl;
    
    private String remark;
}
