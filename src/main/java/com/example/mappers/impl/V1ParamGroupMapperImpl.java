package com.example.mappers.impl;

import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.ParamGroupDTO;
import com.example.mappers.V1ParamGroupMapper;
import com.example.models.ParamGroup;
import com.example.services.ParamGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1ParamGroupMapperImpl implements V1ParamGroupMapper {

    private final ParamGroupService paramGroupService;

    @Override
    public ParamGroup toEntity(ParamGroupDTO dto) {
        if (dto == null) {
            return null;
        }

        ParamGroup paramGroup = new ParamGroup();

        if (dto.getId() != null) {
            paramGroup = paramGroupService.getById(dto.getId()).orElse(new ParamGroup());
        }

        paramGroup = (ParamGroup) ReflectionUtils.mapObject(paramGroup, dto, true, dto.getId() != null);

        return paramGroup;
    }
}
