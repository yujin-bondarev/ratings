package com.example.models;

import by.vstu.dean.core.models.DBBaseModel;
import com.example.models.enums.ESemester;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Модель нагрузки преподавателя.
 */
@Entity
@Table(name = "workloads")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workload extends DBBaseModel {

    /**
     * Год.
     */
    private Integer year;

    /**
     * Семестр.
     */
    @Enumerated(EnumType.STRING)
    private ESemester semester;

    /**
     * Тип деятельности.
     */
    private String activityType;

    /**
     * Часы.
     */
    private Double hours;

    /**
     * Публикации.
     */
    private Double publications;

    /**
     * Рейтинговое значение.
     */
    private Double ratingValue;

    /**
     * Дата подачи.
     */
    private LocalDate dateSubmitted;

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
        Workload that = (Workload) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}