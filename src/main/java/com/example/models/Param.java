package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double weight;
    private Double maxScore;

    @Enumerated(EnumType.STRING)
    private ParamGroup group;
}