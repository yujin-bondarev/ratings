package by.vstu.dean;

import by.vstu.dean.core.configs.security.JwtTokenValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenValidatorStub {

    @Bean
    public JwtTokenValidator jwtTokenValidator() {
        return new JwtTokenValidatorStub();
    }

    public static class JwtTokenValidatorStub extends JwtTokenValidator {

        @Override
        public TokenError validate(@NotNull HttpServletRequest request) {
            return TokenError.EMPTY;
        }
    }
}
