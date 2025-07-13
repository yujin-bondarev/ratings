package com.example.repositories;

import com.example.models.EmpParam;
import by.vstu.dean.core.repo.DBBaseModelRepository;
import com.example.models.enums.EParamType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Интерфейс репозитория параметров оценки преподавателей.
 */
@Repository
public interface EmpParamRepository extends DBBaseModelRepository<EmpParam> {

    /**
     * Найти все параметры по имени группы.
     *
     * @param groupName Имя группы параметров
     * @return Список объектов {@link EmpParam}
     */
    List<EmpParam> findByParam_ParamGroup_Name(String groupName);

    /**
     * Найти все параметры по типу.
     *
     * @param type Тип параметра
     * @return Список объектов {@link EmpParam}
     */
    List<EmpParam> findByParam_Type(EParamType type);

    List<EmpParam> findByTeacherId(Long teacherId);
    List<EmpParam> findByTeacherIdAndParam_ParamGroup_Name(Long teacherId, String groupName);
    List<EmpParam> findByTeacherIdAndParam_Type(Long teacherId, EParamType type);
}