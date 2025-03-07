package com.msislab.robot_ai.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "common_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CommonType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @Column(nullable = false)
    private String name;
    
    private Integer commonId;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    private LocalDateTime updatedAt;
    
    @Column(nullable = false)
    private String createdBy = "admin";
    
    private String updatedBy;
}
