package ru.practicum.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.CreateEndpointHitDto;
import ru.practicum.StatsRequest;
import ru.practicum.ViewStatsDto;
import ru.practicum.service.StatsService;

/**
 * Контроллер для работы со статистикой.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Statistics", description = "API для работы со статистикой обращений к эндпоинтам")
public class StatsController {

    private final StatsService statsService;

    /**
     * Сохраняет информацию об обращении к эндпоинту.
     *
     * @param createEndpointHitDto DTO с информацией об обращении
     */
    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        summary = "Сохранить информацию об обращении")
    @ApiResponse(
        responseCode = "201", description = "Информация успешно сохранена")
    @ApiResponse(
        responseCode = "400", description = "Неверные параметры запроса",
        content = @Content(schema = @Schema(implementation = Void.class)))
    public void createHit(@Valid @RequestBody CreateEndpointHitDto createEndpointHitDto) {

        log.info("Controller: createHit requestBody={}", createEndpointHitDto);
        statsService.createHit(createEndpointHitDto);
    }

    /**
     * Получает статистику за указанный период.
     *
     * @param start  начало периода в формате "yyyy-MM-dd HH:mm:ss"
     * @param end    конец периода в формате "yyyy-MM-dd HH:mm:ss"
     * @param uris   список URI для фильтрации
     * @param unique учитывать только уникальные IP
     * @return список DTO со статистикой
     */
    @GetMapping("/stats")
    @Operation(
        summary = "Получить статистику")
    @ApiResponse(
        responseCode = "200", description = "Статистика успешно получена",
        content = @Content(schema = @Schema(implementation = ViewStatsDto.class)))
    public List<ViewStatsDto> getStats(String start, String end, List<String> uris,
        boolean unique) {

        log.debug("start={}, end={}, uris={}, unique={}", start, end, uris, unique);
        StatsRequest request = StatsRequest.of(start, end, uris, unique);
        log.info("Controller: getStats request={}", request);
        return statsService.getStats(request);
    }
}