package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EmpParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ParamGroup group;

    private Double weight;

    private Double value;
}