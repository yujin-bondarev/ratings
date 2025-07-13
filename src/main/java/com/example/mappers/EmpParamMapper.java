
package com.example.mappers;

import com.example.dto.EmpParamDTO;
import com.example.models.EmpParam;
import com.example.models.Param;

public class EmpParamMapper {

    public static EmpParam toEntity(EmpParamDTO dto, Param param) {
        EmpParam entity = new EmpParam();
        entity.setParam(param);
        entity.setValue(dto.getValue());
        entity.setTeacherId(dto.getTeacherId());
        return entity;
    }

    public static EmpParamDTO toDTO(EmpParam entity) {
        EmpParamDTO dto = new EmpParamDTO();
        dto.setParamId(entity.getParam().getId());
        dto.setValue(entity.getValue());
        dto.setTeacherId(entity.getTeacherId());
        return dto;
    }
}
