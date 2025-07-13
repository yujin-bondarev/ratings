
package com.example.controllers;

import com.example.models.Param;
import com.example.repositories.ParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/param")
public class ParamController {

    @Autowired
    private ParamRepository repo;

    @GetMapping
    public List<Param> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Param create(@RequestBody Param param) {
        return repo.save(param);
    }
}
