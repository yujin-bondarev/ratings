
package com.example.repositories;

import com.example.models.Teacher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Мок-репозиторий для Teacher (вместо настоящего доступа к БД)
 */
@Repository
@Primary
public class TeacherRepository {

    public Optional<Teacher> findById(Long id) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFullName("Мок Преподаватель #" + id);
        teacher.setEmail("mock" + id + "@example.com");
        return Optional.of(teacher);
    }
}
