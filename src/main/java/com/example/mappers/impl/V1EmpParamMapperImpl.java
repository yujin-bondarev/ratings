package com.example.mappers.impl;

import by.vstu.dean.core.utils.ReflectionUtils;
import by.vstu.dean.models.lessons.AbsenceModel;
import com.example.dto.EmpParamDTO;
import com.example.mappers.V1EmpParamMapper;
import com.example.models.EmpParam;
import com.example.services.EmpParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1EmpParamMapperImpl implements V1EmpParamMapper {

    private final EmpParamService empParamService;

    @Override
    public EmpParam toEntity(EmpParamDTO dto) {
        if (dto == null) {
            return null;
        }

        EmpParam empParam = new EmpParam();

        if(dto.getId() != null)
            empParam = this.empParamService.getById(dto.getId()).orElse(new EmpParam());

        empParam = (EmpParam) ReflectionUtils.mapObject(empParam, dto, true, dto.getId() != null);

        return empParam;
    }

}
