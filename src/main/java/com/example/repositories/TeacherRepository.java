package com.example.repositories;

import com.example.models.Param;
import by.vstu.dean.core.repo.DBBaseModelRepository;

/**
 * Репозиторий для работы с преподавателями (заглушка до подключения к внешней БД).
 */
//@Deprecated   Нужна ли?
// Заменить при подключении к реальному API или БД преподавателей
public interface TeacherRepository extends DBBaseModelRepository<Param> {
}