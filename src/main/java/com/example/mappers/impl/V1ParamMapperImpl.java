package com.example.mappers.impl;

import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.ParamDTO;
import com.example.mappers.V1ParamMapper;
import com.example.models.Param;
import com.example.services.ParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1ParamMapperImpl implements V1ParamMapper {

    private final ParamService paramService;

    @Override
    public Param toEntity(ParamDTO dto) {
        if (dto == null) {
            return null;
        }

        Param param = new Param();

        if (dto.getId() != null) {
            param = paramService.getById(dto.getId()).orElse(new Param());
        }

        param = (Param) ReflectionUtils.mapObject(param, dto, true, dto.getId() != null);

        return param;
    }
}
