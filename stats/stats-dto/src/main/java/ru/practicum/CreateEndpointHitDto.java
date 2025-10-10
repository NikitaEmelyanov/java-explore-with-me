package ru.practicum;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * DTO для создания записи о обращении к эндпоинту.
 */
@Schema(description = "DTO для создания записи о обращении к эндпоинту")
public record CreateEndpointHitDto(
    @NotBlank(message = "Название приложения не может быть пустым")
    @Schema(description = "Идентификатор сервиса", example = "ewm-main-service")
    String app,

    @NotBlank(message = "URI не может быть пустым")
    @Schema(description = "URI запроса", example = "/events/1")
    String uri,

    @NotBlank(message = "IP адрес не может быть пустым")
    @Schema(description = "IP-адрес пользователя", example = "192.168.1.1")
    String ip,

    @NotNull(message = "Временная метка не может быть null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Дата и время запроса", example = "2024-01-01 12:00:00")
    LocalDateTime timestamp
) {

}