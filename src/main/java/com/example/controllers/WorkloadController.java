
package com.example.controllers;

import com.example.models.Workload;
import com.example.repositories.WorkloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workload")
public class WorkloadController {

    @Autowired
    private WorkloadRepository repo;

    @GetMapping
    public List<Workload> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Workload create(@RequestBody Workload workload) {
        return repo.save(workload);
    }
}
