package com.example.controllers;

import com.example.models.EmpParam;
import com.example.models.enums.EParamType;
import com.example.services.EmpParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import by.vstu.dean.core.configs.security.TokenStore;
import by.vstu.dean.core.auth.dto.UserDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/params")
public class EmpParamController {

    @Autowired
    private EmpParamService empParamService;

    @Autowired
    private TokenStore tokenStore;

    // --- CRUD ---
    @GetMapping("/")
    public List<EmpParam> getAllEmpParams() {
        return empParamService.getAll();
    }

    @GetMapping("/types")
    public List<Map<String, String>> getAllEParamType() {
        return EParamType.OTHER.getValues().stream()
                .map(type -> Map.of(
                        "value", type.name(),
                        "description", type.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public EmpParam createEmpParam(@RequestBody EmpParam empParam) {
        return empParamService.save(empParam);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpParam(@PathVariable Long id) {
        empParamService.delete(id);
    }

    // --- Расчет рейтинга без фильтров ---
    @PostMapping("/calculate")
    public Double calculateRating(@RequestBody List<EmpParam> empParams) {
        return empParamService.calculateRating(empParams);
    }

    // --- Расчет по группе параметров ---
    @GetMapping("/calculate/by-group")
    public Double calculateByGroup(@RequestParam String groupName) {
        UserDTO user = tokenStore.getUser();
        Long teacherId = Long.parseLong(user.getExternalId());
        return empParamService.calculateByGroup(teacherId, groupName);
    }

    // --- Расчет по типу параметра ---
    @GetMapping("/calculate/by-type")
    public Double calculateByType(@RequestParam EParamType type) {
        UserDTO user = tokenStore.getUser();
        Long teacherId = Long.parseLong(user.getExternalId());
        return empParamService.calculateByType(teacherId, type);
    }

    // --- Расчет с фильтром: по группе или типу ---
    @PostMapping("/calculate/filter")
    public Double calculateWithFilter(
            @RequestParam(required = false) String groupName,
            @RequestParam(required = false) EParamType type,
            @RequestBody(required = false) List<EmpParam> empParams) {

        UserDTO user = tokenStore.getUser();
        Long teacherId = Long.parseLong(user.getExternalId());
        return empParamService.calculateWithFilter(teacherId, groupName, type);
    }
}
