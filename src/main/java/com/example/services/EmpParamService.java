package com.example.services;

import com.example.models.EmpParam;
import com.example.models.Param;
import com.example.models.enums.EParamType;
import com.example.repositories.EmpParamRepository;
import by.vstu.dean.core.services.BaseService;
import by.vstu.dean.core.websocket.WSControllerManager;
import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * Сервис для работы с параметрами оценки преподавателей.
 */
@Service
@Transactional
public class EmpParamService extends BaseService<EmpParam, EmpParamRepository> {

    public EmpParamService(EmpParamRepository repo, Javers javers, WSControllerManager tm) {
        super(repo, javers, tm);
    }

    /**
     * Расчёт рейтинга по всем переданным параметрам.
     */
    public Double calculateRating(List<EmpParam> empParams) {
        return empParams.stream()
                .mapToDouble(ep -> ep.getParam().getWeight() * ep.getValue())
                .sum();
    }

    /**
     * Расчёт рейтинга по группе параметров.
     */
    public Double calculateByGroup(Long teacherId, String groupName) {
        List<EmpParam> params = repo.findByTeacherIdAndParam_ParamGroup_Name(teacherId, groupName);
        return calculateRating(params);
    }

    /**
     * Расчёт рейтинга по типу параметра.
     */
    public Double calculateByType(Long teacherId, EParamType type) {
        List<EmpParam> params = repo.findByTeacherIdAndParam_Type(teacherId, type);
        return calculateRating(params);
    }

    /**
     * Расчёт рейтинга с фильтром: группа или тип.
     */
    public Double calculateWithFilter(Long teacherId, String groupName, EParamType type) {
        List<EmpParam> params;

        if (groupName != null && !groupName.isEmpty()) {
            params = repo.findByTeacherIdAndParam_ParamGroup_Name(teacherId, groupName);
        } else if (type != null) {
            params = repo.findByTeacherIdAndParam_Type(teacherId, type);
        } else {
            params = repo.findByTeacherId(teacherId);
        }

        return calculateRating(params);
    }
}