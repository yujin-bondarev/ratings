package com.example.dto;

import by.vstu.dean.core.anotations.ReflectionField;
import by.vstu.dean.core.dto.PublicDTO;
import com.example.models.ParamGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO для группы параметров (ParamGroup).
 */
@Data
public class ParamGroupDTO extends PublicDTO {

    @NotNull
    @ReflectionField(clazz = ParamGroup.class)
    private String name;

    @NotNull
    @ReflectionField(clazz = ParamGroup.class)
    private Boolean enabled;
}
