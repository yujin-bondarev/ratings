package com.example.mappers;

import by.vstu.dean.core.models.mapper.BaseMapperInterface;
import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.ParamDTO;
import com.example.models.Param;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface V1ParamMapper extends BaseMapperInterface<ParamDTO, Param> {

    @Override
    default ParamDTO toDto(Param entity) {
        return entity == null ? null : (ParamDTO) ReflectionUtils.mapObject(entity, new ParamDTO(), false, false);
    }
}
