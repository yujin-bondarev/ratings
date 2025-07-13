
package com.example.services;

import com.example.models.Teacher;
import org.springframework.stereotype.Service;

/**
 * Мок-сервис для получения преподавателей (временно заменяет доступ к базе).
 */
@Service
public class TeacherService {

    public Teacher getById(Long teacherId) {
        // Мок-объект преподавателя
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacher.setFullName("Преподаватель #" + teacherId);
        teacher.setEmail("teacher" + teacherId + "@university.edu");
        return teacher;
    }
}
