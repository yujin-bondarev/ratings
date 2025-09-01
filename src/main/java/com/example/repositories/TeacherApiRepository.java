package com.example.repositories;

import com.example.models.TeacherModel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository // Регистрируем как Spring Bean
public class TeacherApiRepository extends DeanApiRepositoryBase<TeacherModel> {
    @Value("${spring.application.token}")
    private String token;
    @PostConstruct
    public void init() {
        this.setToken(this.token);
    }
    public TeacherApiRepository() {
        super("teachers/", TeacherModel.class); // Этот вызов требует, чтобы @Value был доступен. Лучше передать baseUrl через DI в конструкторе RatingApiRepositoryBase.
        // Или используйте @Autowired конструктор в RatingApiRepositoryBase.
//        setTokenRequest(this.tokenRequest);
    }


}