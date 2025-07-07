package com.example.repositories;

import com.example.models.EmpParam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpParamRepository extends JpaRepository<EmpParam, Long> {
    List<EmpParam> findByParam_ParamGroup_Name(String groupName);
    List<EmpParam> findByParam_Type(EParamType type);
}