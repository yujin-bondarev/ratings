package com.example.mappers;

import by.vstu.dean.core.models.mapper.BaseMapperInterface;
import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.EmpParamDTO;
import com.example.models.EmpParam;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface V1EmpParamMapper extends BaseMapperInterface<EmpParamDTO, EmpParam> {

    @Override
    default EmpParamDTO toDto(EmpParam entity) {
        return entity == null ? null : (EmpParamDTO) ReflectionUtils.mapObject(entity, new EmpParamDTO(), false, false);
    }

}
