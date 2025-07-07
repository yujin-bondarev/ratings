package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Param {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Название критерия

    @ManyToOne
    @JoinColumn(name = "param_group_id")
    private ParamGroup paramGroup; // Группа критериев

    @Enumerated(EnumType.STRING)
    private EParamType type; // Тип критерия

    private Double weight; // Весовой коэффициент

    private String comment; // Комментарий
}