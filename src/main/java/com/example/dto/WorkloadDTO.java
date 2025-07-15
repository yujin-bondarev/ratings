package com.example.dto;

import by.vstu.dean.core.anotations.ReflectionField;
import by.vstu.dean.core.dto.PublicDTO;
import com.example.models.Workload;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO для нагрузки преподавателя (Workload).
 */
@Data
public class WorkloadDTO extends PublicDTO {

    @NotNull
    @ReflectionField(clazz = Workload.class)
    private Long teacherId;

    @NotNull
    @ReflectionField(clazz = Workload.class)
    private Integer value;
}
