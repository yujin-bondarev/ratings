
package com.example.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * DTO для оценки преподавателя (EmpParam).
 */
@Data
public class EmpParamDTO {

    @NotNull
    private Long paramId;

    private Double value;

    private Long teacherId;
}
