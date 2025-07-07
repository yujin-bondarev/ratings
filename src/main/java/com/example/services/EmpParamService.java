package com.example.services;

import com.example.models.EmpParam;
import com.example.models.Param;
import com.example.repositories.EmpParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpParamService {

    @Autowired
    private EmpParamRepository empParamRepository;

    // --- Базовые методы ---
    public List<EmpParam> getAllEmpParams() {
        return empParamRepository.findAll();
    }

    public EmpParam saveEmpParam(EmpParam empParam) {
        return empParamRepository.save(empParam);
    }

    public void deleteEmpParam(Long id) {
        empParamRepository.deleteById(id);
    }

    // --- Расчет рейтинга по всем параметрам ---
    public Double calculateRating(List<EmpParam> empParams) {
        return empParams.stream()
                .mapToDouble(ep -> ep.getParam().getWeight() * ep.getValue())
                .sum();
    }

    // --- Расчет рейтинга по группе ---
    public Double calculateByGroup(String groupName) {
        List<EmpParam> params = empParamRepository.findByParam_ParamGroup_Name(groupName);
        return calculateRating(params);
    }

    // --- Расчет рейтинга по типу ---
    public Double calculateByType(EParamType type) {
        List<EmpParam> params = empParamRepository.findByParam_Type(type);
        return calculateRating(params);
    }

    // --- Расчет с фильтром: группа или тип ---
    public Double calculateWithFilter(String groupName, EParamType type) {
        List<EmpParam> params = List.of();

        if (groupName != null && !groupName.isEmpty()) {
            params = empParamRepository.findByParam_ParamGroup_Name(groupName);
        } else if (type != null) {
            params = empParamRepository.findByParam_Type(type);
        } else {
            params = getAllEmpParams();
        }

        return calculateRating(params);
    }
}