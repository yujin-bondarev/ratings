package by.vstu.dean;

import by.vstu.dean.core.logging.services.LoggerService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@ConditionalOnProperty(name = "dean.logging.enabled", havingValue = "false")
public class LoggerStubConfig {

    @Bean
    public LoggerService loggerService() {
        return new LoggerService(null) {
//            @Override
            public void log(HttpServletRequest request, HttpServletResponse response, Exception ex) {
                // ничего не делаем
            }

            @Override
            public void removeOldLogs() {
                // ничего не делаем
            }
        };
    }
}
