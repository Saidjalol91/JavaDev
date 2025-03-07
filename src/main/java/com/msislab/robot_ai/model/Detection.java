package com.msislab.robot_ai.model;

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
    private String machine_id;
    private Integer product_id;
    private Integer surface_id;
    private Integer model_id; 

    private String name;
    private String email;

}
