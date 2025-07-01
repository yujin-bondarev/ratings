package com.example.controllers;

import com.example.models.EmpParam;
import com.example.services.EmpParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/params")
public class EmpParamController {

    @Autowired
    private EmpParamService empParamService;

    @GetMapping
    public List<EmpParam> getAllParams() {
        return empParamService.getAllParams();
    }

    @PostMapping
    public EmpParam createParam(@RequestBody EmpParam param) {
        return empParamService.saveParam(param);
    }

    @GetMapping("/{id}")
    public EmpParam getParamById(@PathVariable Long id) {
        return empParamService.getParamById(id);
    }

    @PutMapping("/{id}")
    public EmpParam updateParam(@PathVariable Long id, @RequestBody EmpParam updatedParam) {
        return empParamService.updateParam(id, updatedParam);
    }

    @DeleteMapping("/{id}")
    public void deleteParam(@PathVariable Long id) {
        empParamService.deleteParam(id);
    }
}