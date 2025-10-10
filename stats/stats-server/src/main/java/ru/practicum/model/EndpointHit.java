package ru.practicum.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность для хранения информации о обращениях к эндпоинтам.
 */
@Entity
@Table(name = "endpoint_hits")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Сущность для хранения информации о обращениях к эндпоинтам")
public class EndpointHit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Schema(description = "Уникальный идентификатор записи", example = "1")
    @Column(name = "hit_id")
    private Long id;

    @Schema(description = "Идентификатор сервиса", example = "ewm-main-service")
    private String app;

    @Schema(description = "URI запроса", example = "/events/1")
    private String uri;

    @Schema(description = "IP-адрес пользователя", example = "192.168.1.1")
    private String ip;

    @Schema(description = "Дата и время запроса", example = "2024-01-01 12:00:00")
    private LocalDateTime timestamp;
}