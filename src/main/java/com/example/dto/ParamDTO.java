package com.example.dto;

import by.vstu.dean.core.anotations.ReflectionField;
import by.vstu.dean.core.dto.PublicDTO;
import by.vstu.dean.core.models.DBBaseModel;
import com.example.models.Param;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO для параметра оценки (Param).
 */
@Data
public class ParamDTO extends PublicDTO {

    @NotNull
    @ReflectionField(clazz = Param.class)
    private String name;

    @NotNull
    @ReflectionField(clazz = Param.class)
    private Double maxValue;

    @NotNull
    @ReflectionField(clazz = Param.class)
    private Boolean enabled;

    @NotNull
    @ReflectionField(clazz = Param.class)
    private Long paramGroupId;
}
