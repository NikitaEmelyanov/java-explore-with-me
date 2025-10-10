package ru.practicum;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Запрос для получения статистики.
 */
@Schema(description = "Запрос для получения статистики")
public record StatsRequest(
    @Schema(description = "Дата и время начала диапазона")
    LocalDateTime start,

    @Schema(description = "Дата и время окончания диапазона")
    LocalDateTime end,

    @Schema(description = "Список URI для фильтрации")
    List<String> uris,

    @Schema(description = "Учитывать только уникальные IP")
    boolean unique
) {

    /**
     * Создает StatsRequest из строковых параметров.
     *
     * @param start  дата начала в формате "yyyy-MM-dd HH:mm:ss"
     * @param end    дата окончания в формате "yyyy-MM-dd HH:mm:ss"
     * @param uris   список URI для фильтрации
     * @param unique учитывать только уникальные IP
     * @return объект StatsRequest
     */
    public static StatsRequest of(String start, String end, List<String> uris, boolean unique) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new StatsRequest(
            LocalDateTime.parse(start, formatter),
            LocalDateTime.parse(end, formatter),
            uris,
            unique
        );
    }
}