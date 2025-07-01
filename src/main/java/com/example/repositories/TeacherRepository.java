package com.example.repositories;

import com.example.models.Param;
import org.springframework.data.jpa.repository.JpaRepository;

// Примерная заглушка — будет заменена при подключении к внешней БД
public interface TeacherRepository extends JpaRepository<Param, Long> {
}