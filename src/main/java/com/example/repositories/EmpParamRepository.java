package com.example.repositories;

import com.example.models.EmpParam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpParamRepository extends JpaRepository<EmpParam, Long> {
    List<EmpParam> findByGroup(ParamGroup group);
}