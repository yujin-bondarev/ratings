package com.example.services;

import com.example.models.Workload;
import com.example.repositories.WorkloadRepository;
import by.vstu.dean.core.services.BaseService;
import by.vstu.dean.core.websocket.WSControllerManager;
import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с учебной нагрузкой.
 */
@Service
@Transactional
public class WorkloadService extends BaseService<Workload, WorkloadRepository> {

    public WorkloadService(WorkloadRepository repo, Javers javers, WSControllerManager tm) {
        super(repo, javers, tm);
    }
}
