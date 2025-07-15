package com.example.mappers;

import by.vstu.dean.core.models.mapper.BaseMapperInterface;
import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.ParamGroupDTO;
import com.example.models.ParamGroup;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface V1ParamGroupMapper extends BaseMapperInterface<ParamGroupDTO, ParamGroup> {

    @Override
    default ParamGroupDTO toDto(ParamGroup entity) {
        return entity == null ? null : (ParamGroupDTO) ReflectionUtils.mapObject(entity, new ParamGroupDTO(), false, false);
    }
}
