package ru.practicum;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO для отображения статистики.
 */
@Schema(description = "DTO для отображения статистики")
public record ViewStatsDto(
    @Schema(description = "Идентификатор сервиса", example = "ewm-main-service")
    String app,

    @Schema(description = "URI запроса", example = "/events/1")
    String uri,

    @Schema(description = "Количество обращений", example = "15")
    Long hits
) {

}