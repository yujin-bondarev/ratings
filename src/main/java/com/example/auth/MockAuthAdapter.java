package com.example.auth;

import org.springframework.stereotype.Component;

@Component
public class MockAuthAdapter {
    // Заглушка для адаптера аутентификации
    public boolean isAuthenticated() {
        return true; // Временная реализация
    }

    public String getCurrentUser() {
        return "mock-user";
    }
}