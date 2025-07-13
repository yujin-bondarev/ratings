package by.vstu.dean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Главный класс приложения.
 * Должен находиться в пакете by.vstu.dean для корректной инициализации ядра.
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "by.vstu.dean",
        "by.vstu.dean.core"
}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "by\\.vstu\\.dean\\.core\\.logging\\..*")
})

@EnableJpaRepositories(basePackages = {
        "by.vstu.dean.repositories",
//        "by.vstu.dean.core.logging.repo"
})
@EntityScan(basePackages = {
        "by.vstu.dean.entities",
//        "by.vstu.dean.core.logging.models"
})
public class RatingApp {

    public static void main(String[] args) {
        SpringApplication.run(RatingApp.class, args);

    }
}

