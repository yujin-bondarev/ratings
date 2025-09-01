package com.example.models; // Замените на ваш пакет

import by.vstu.dean.core.models.DBBaseModel; // Импорт из JAR/WAR основного бэка
import com.google.gson.annotations.SerializedName; // Если используется Gson внутри ApiRepositoryBase
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

// Ваша локальная копия TeacherModel, наследующая DBBaseModel из основного бэка
@Setter
@Getter
public class TeacherModel extends DBBaseModel {

    @SerializedName("surname") // Имя поля в JSON ответе API
    private String surname;

    @SerializedName("name")
    private String name;

    @SerializedName("patronymic")
    private String patronymic;

    // Пример поля-ссылки (если нужно)
    // @SerializedName("degree")
    // private TeacherDegreeModel degree; // И соответствующая модель TeacherDegreeModel

    @SerializedName("photoUrl")
    private String photoUrl;

    // Конструктор по умолчанию
    public TeacherModel() {
        super(); // Вызов конструктора родителя DBBaseModel
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "id=" + this.getId() +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                // ", degree=" + degree +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherModel)) return false;
        if (!super.equals(o)) return false; // Сравнение по ID из DBBaseModel
        TeacherModel that = (TeacherModel) o;
        return Objects.equals(surname, that.surname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(patronymic, that.patronymic) &&
                // Objects.equals(degree, that.degree) &&
                Objects.equals(photoUrl, that.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), surname, name, patronymic/*, degree*/, photoUrl);
    }
}