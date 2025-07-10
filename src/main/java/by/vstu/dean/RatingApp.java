package by.vstu.dean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения.
 * Должен находиться в пакете by.vstu.dean для корректной инициализации ядра.
 */
@SpringBootApplication(scanBasePackages = {
        "by.vstu.dean",
        "com.example"
})
public class RatingApp {

    public static void main(String[] args) {
        SpringApplication.run(RatingApp.class, args);
    }
}