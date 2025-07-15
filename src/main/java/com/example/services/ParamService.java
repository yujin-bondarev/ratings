package com.example.services;

import com.example.models.Param;
import com.example.repositories.ParamRepository;
import by.vstu.dean.core.services.BaseService;
import by.vstu.dean.core.websocket.WSControllerManager;
import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с параметрами.
 */
@Service
@Transactional
public class ParamService extends BaseService<Param, ParamRepository> {

    public ParamService(ParamRepository repo, Javers javers, WSControllerManager tm) {
        super(repo, javers, tm);
    }
}
