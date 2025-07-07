package com.example.controllers;

import com.example.models.EmpParam;
import com.example.models.enums.EParamType;
import com.example.services.EmpParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/params")
public class EmpParamController {

    @Autowired
    private EmpParamService empParamService;

    // --- CRUD ---
    @GetMapping
    public List<EmpParam> getAllEmpParams() {
        return empParamService.getAllEmpParams();
    }

    @PostMapping
    public EmpParam createEmpParam(@RequestBody EmpParam empParam) {
        return empParamService.saveEmpParam(empParam);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpParam(@PathVariable Long id) {
        empParamService.deleteEmpParam(id);
    }

    // --- Расчет рейтинга ---
    @PostMapping("/calculate")
    public Double calculateRating(@RequestBody List<EmpParam> empParams) {
        return empParamService.calculateRating(empParams);
    }

    @GetMapping("/calculate/by-group")
    public Double calculateByGroup(@RequestParam String groupName) {
        return empParamService.calculateByGroup(groupName);
    }

    @GetMapping("/calculate/by-type")
    public Double calculateByType(@RequestParam EParamType type) {
        return empParamService.calculateByType(type);
    }

    @PostMapping("/calculate/filter")
    public Double calculateWithFilter(
            @RequestParam(required = false) String groupName,
            @RequestParam(required = false) EParamType type,
            @RequestBody(required = false) List<EmpParam> empParams) {

        return empParamService.calculateWithFilter(groupName, type);
    }
}