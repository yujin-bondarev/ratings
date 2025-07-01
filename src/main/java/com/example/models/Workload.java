package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Workload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    @Enumerated(EnumType.STRING)
    private ESemester semester;

    private String activityType;

    private Double hours;
    private Double publications;
    private Double ratingValue;

    private LocalDate dateSubmitted;
}