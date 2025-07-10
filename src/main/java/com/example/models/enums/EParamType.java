package com.example.models.enums;

import com.example.models.BaseEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;
import java.util.List;

/**
 * Перечисление типов параметров.
 */
@Schema(title = "Тип параметра")
public enum EParamType implements BaseEnum<EParamType> {

    /**
     * Неизвестный тип.
     */
    @Schema(title = "Неизвестный тип")
    UNKNOWN(0, "Неизвестный тип"),

    /**
     * Учебная деятельность.
     */
    @Schema(title = "Учебная деятельность")
    ACADEMIC_ACTIVITY(1, "Учебная деятельность"),

    /**
     * Научно-исследовательская работа.
     */
    @Schema(title = "Научно-исследовательская работа")
    SCIENTIFIC_RESEARCH(2, "Научно-исследовательская работа"),

    /**
     * Другое.
     */
    @Schema(title = "Другое")
    OTHER(3, "Другое");

    /**
     * Идентификатор типа параметра.
     */
    @Schema(title = "Идентификатор типа параметра")
    private final int id;

    /**
     * Описание типа параметра.
     */
    @Schema(title = "Описание типа параметра")
    private final String description;

    /**
     * Конструктор с параметрами.
     *
     * @param id          Идентификатор типа параметра
     * @param description Описание типа параметра
     */
    EParamType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Получает тип параметра по идентификатору.
     *
     * @param id Идентификатор
     * @return Тип параметра или UNKNOWN
     */
    public static EParamType valueOf(int id) {
        return Arrays.stream(values())
                .filter(p -> p.id == id)
                .findFirst()
                .orElse(UNKNOWN);
    }

    /**
     * Возвращает список всех значений.
     *
     * @return Список всех типов параметров
     */
    @Override
    public List<EParamType> getValues() {
        return Arrays.stream(values()).toList();
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}