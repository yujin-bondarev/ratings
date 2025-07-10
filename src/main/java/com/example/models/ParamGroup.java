package com.example.models;

import by.vstu.dean.core.models.DBBaseModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Модель группы критериев.
 */
@Entity
@Table(name = "param_groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Модель группы критериев")
public class ParamGroup extends DBBaseModel {

    /**
     * Название группы критериев.
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

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
        ParamGroup that = (ParamGroup) o;
        return getId() != null && Objects.equals(that.getId(), getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}