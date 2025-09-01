package com.example.repositories;

import by.vstu.dean.core.models.DBBaseModel;
import by.vstu.dean.core.requests.TokenRequest;
import by.vstu.dean.core.requests.repo.ApiRepositoryBase;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

public class DeanApiRepositoryBase<O extends DBBaseModel> extends ApiRepositoryBase<O> {



//    protected final TokenRequest tokenRequest;

    public DeanApiRepositoryBase(String endpoint, Class<O> target) {
        super("https://olympiadb.vstu.by/api/v1/repo/", endpoint, "", target);
//        this.tokenRequest = tokenRequest;
        this.setTokenRequest(new TokenRequest());
    }

}