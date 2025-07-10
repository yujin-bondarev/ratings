package com.example.models;

import by.vstu.dean.core.models.DBBaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Модель параметра оценки преподавателя.
 */
@Entity
@Table(name = "emp_params")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpParam extends DBBaseModel {


    @NotNull
    @ManyToOne
    @JoinColumn(name = "param_id")
    private Param param;

    /**
     * Значение, введённое пользователем.
     */
    private Double value;

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

        if (thisEffectiveClass != oEffectiveClass) return false;
        EmpParam that = (EmpParam) o;
        return getId() != null && Objects.equals(that.getId(), getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}