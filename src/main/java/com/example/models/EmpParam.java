package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EmpParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "param_id")
    private Param param; // Ссылка на параметр

    private Double value; // Значение, введённое пользователем
}