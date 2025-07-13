
package com.example.dto;

import com.example.models.enums.EParamType;
import lombok.Data;

@Data
public class ParamDTO {
    private String name;
    private EParamType type;
    private Double weight;
    private Long groupId;
}
