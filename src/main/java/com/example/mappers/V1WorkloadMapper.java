package com.example.mappers;

import by.vstu.dean.core.models.mapper.BaseMapperInterface;
import by.vstu.dean.core.utils.ReflectionUtils;
import com.example.dto.WorkloadDTO;
import com.example.models.Workload;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface V1WorkloadMapper extends BaseMapperInterface<WorkloadDTO, Workload> {

    @Override
    default WorkloadDTO toDto(Workload entity) {
        return entity == null ? null : (WorkloadDTO) ReflectionUtils.mapObject(entity, new WorkloadDTO(), false, false);
    }
}
