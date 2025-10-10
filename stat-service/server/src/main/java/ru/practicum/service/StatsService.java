package ru.practicum.service;

import java.util.List;
import ru.practicum.CreateEndpointHitDto;
import ru.practicum.StatsRequest;
import ru.practicum.ViewStatsDto;

/**
 * Сервис для работы со статистикой.
 */
public interface StatsService {

    /**
     * Сохраняет информацию об обращении к эндпоинту.
     *
     * @param createEndpointHitDto DTO с информацией об обращении
     */
    void createHit(CreateEndpointHitDto createEndpointHitDto);

    /**
     * Получает статистику за указанный период.
     *
     * @param request параметры запроса статистики
     * @return список DTO со статистикой
     */
    List<ViewStatsDto> getStats(StatsRequest request);
}