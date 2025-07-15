package com.example.services;

import com.example.models.ParamGroup;
import com.example.repositories.ParamGroupRepository;
import by.vstu.dean.core.services.BaseService;
import by.vstu.dean.core.websocket.WSControllerManager;
import org.javers.core.Javers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с группами параметров.
 */
@Service
@Transactional
public class ParamGroupService extends BaseService<ParamGroup, ParamGroupRepository> {

    public ParamGroupService(ParamGroupRepository repo, Javers javers, WSControllerManager tm) {
        super(repo, javers, tm);
    }
}
