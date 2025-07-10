package com.example.models.enums;

import by.vstu.dean.core.enums.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Перечисление, реализующее тип семестра.
 */
@Schema(title = "Семестр")
public enum ESemester implements BaseEnum<ESemester> {

    /**
     * Неизвестный семестр.
     */
    @Schema(title = "Неизвестный семестр")
    UNKNOWN(0, ""),

    /**
     * Весенний семестр.
     */
    @Schema(title = "Весенний семестр")
    SPRING(1, "Весенний"),
    /**
     * Осенний семестр.
     */
    @Schema(title = "Осенний семестр")
    AUTUMN(2, "Осенний");

    /**
     * Идентификатор типа семестра.
     */
    @Schema(title = "Идентификатор типа семестра")
    final int id;
    /**
     * Название типа семестра.
     */
    @Schema(title = "Название типа семестра")
    @Getter
    @JsonValue
    final String name;

    /**
     * Параметризованный конструктор.
     *
     * @param id   Идентификатор типа семестра
     * @param name Название типа семестра
     */
    ESemester(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Метод для определения семестра на момент конкретной даты.
     *
     * @param date Дата, на которую необходимо узнать семестр
     * @return Семестр
     */
    public static ESemester getByDate(LocalDate date) {
        if (date == null)
            return UNKNOWN;

        if (date.getMonthValue() > 6)
            return AUTUMN;
        return SPRING;
    }

    @Override
    public List<ESemester> getValues() {
        return Arrays.stream(ESemester.values()).toList();
    }

}
