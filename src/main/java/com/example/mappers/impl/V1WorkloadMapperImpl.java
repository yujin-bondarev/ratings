package com.example.mappers.impl;

import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.WorkloadDTO;
import com.example.mappers.V1WorkloadMapper;
import com.example.models.Workload;
import com.example.services.WorkloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class V1WorkloadMapperImpl implements V1WorkloadMapper {

    private final WorkloadService workloadService;

    @Override
    public Workload toEntity(WorkloadDTO dto) {
        if (dto == null) {
            return null;
        }

        Workload workload = new Workload();

        if (dto.getId() != null) {
            workload = workloadService.getById(dto.getId()).orElse(new Workload());
        }

        workload = (Workload) ReflectionUtils.mapObject(workload, dto, true, dto.getId() != null);

        return workload;
    }
}
