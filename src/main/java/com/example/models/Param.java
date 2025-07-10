package com.example.models;

import by.vstu.dean.core.models.DBBaseModel;
import com.example.models.enums.EParamType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Модель параметра оценки преподавателя.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Param extends DBBaseModel {

    /**
     * Название критерия или описание условия.
     */
    @NotNull
    private String name;

    /**
     * Группа критериев (не enum, отдельный класс).
     */
    @ManyToOne
    @JoinColumn(name = "param_group_id")
    private ParamGroup paramGroup;

    /**
     * Тип критерия (enum: ACADEMIC_ACTIVITY, SCIENTIFIC_RESEARCH, OTHER)
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private EParamType type;

    /**
     * Весовой коэффициент (используется при расчете рейтинга).
     */
    @NotNull
    private Double weight;

    /**
     * Комментарий (описание параметра).
     */
    private String comment;

    /**
     * Описание/подсказка, которая отображается пользователю в интерфейсе.
     * Например: "Укажите количество часов" или "Максимум 5 публикаций"
     */
    private String description;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
                ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() :
                o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() :
                getClass();

        if (!oEffectiveClass.equals(thisEffectiveClass)) return false;
        Param that = (Param) o;
        return getId() != null && Objects.equals(that.getId(), getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}