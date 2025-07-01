package com.example.services;

import com.example.models.EmpParam;
import com.example.repositories.EmpParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpParamService {

    @Autowired
    private EmpParamRepository empParamRepository;

    public List<EmpParam> getAllParams() {
        return empParamRepository.findAll();
    }

    public EmpParam saveParam(EmpParam param) {
        return empParamRepository.save(param);
    }

    public EmpParam getParamById(Long id) {
        return empParamRepository.findById(id).orElse(null);
    }

    public EmpParam updateParam(Long id, EmpParam updatedParam) {
        Optional<EmpParam> existingParamOpt = empParamRepository.findById(id);
        if (existingParamOpt.isPresent()) {
            EmpParam existingParam = existingParamOpt.get();
            existingParam.setName(updatedParam.getName());
            existingParam.setGroup(updatedParam.getGroup());
            existingParam.setWeight(updatedParam.getWeight());
            existingParam.setValue(updatedParam.getValue());
            return empParamRepository.save(existingParam);
        }
        return null;
    }

    public void deleteParam(Long id) {
        empParamRepository.deleteById(id);
    }
}