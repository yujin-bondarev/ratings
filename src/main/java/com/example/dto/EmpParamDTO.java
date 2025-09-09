
package com.example.dto;

import by.vstu.dean.core.anotations.ReflectionField;
import by.vstu.dean.core.dto.PublicDTO;
import by.vstu.dean.core.models.DBBaseModel;
import com.example.models.EmpParam;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * DTO для оценки преподавателя (EmpParam).
 */
@Data
public class EmpParamDTO extends PublicDTO {

    @NotNull
    private Long paramId;

    @ReflectionField(value = "value", clazz = EmpParam.class)
    private Double value;
    @ReflectionField(clazz = EmpParam.class)
    private Long teacherId;
}
