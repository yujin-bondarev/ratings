
package com.example.controllers;

import com.example.models.ParamGroup;
import com.example.repositories.ParamGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/param-group")
public class ParamGroupController {

    @Autowired
    private ParamGroupRepository repo;

    @GetMapping
    public List<ParamGroup> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public ParamGroup create(@RequestBody ParamGroup paramGroup) {
        return repo.save(paramGroup);
    }
}
