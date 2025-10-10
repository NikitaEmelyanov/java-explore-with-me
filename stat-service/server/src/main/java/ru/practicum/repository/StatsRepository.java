package ru.practicum.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.ViewStatsDto;
import ru.practicum.model.EndpointHit;

/**
 * Репозиторий для работы с обращениями к эндпоинтам.
 */
public interface StatsRepository extends JpaRepository<EndpointHit, Long> {

    /**
     * Получает статистику с учетом уникальных IP-адресов.
     *
     * @param start начало периода
     * @param end   конец периода
     * @param uris  список URI для фильтрации (может быть null)
     * @return список DTO со статистикой
     */
    @Query("""
        SELECT new ru.practicum.ViewStatsDto(e.app, e.uri, COUNT(DISTINCT e.ip))
        FROM EndpointHit e
        WHERE e.timestamp BETWEEN :start AND :end
        AND (:uris IS NULL OR e.uri IN :uris)
        GROUP BY e.app, e.uri
        ORDER BY COUNT(DISTINCT e.ip) DESC
        """)
    List<ViewStatsDto> getUniqueStats(LocalDateTime start, LocalDateTime end, List<String> uris);

    /**
     * Получает статистику без учета уникальности IP-адресов.
     *
     * @param start начало периода
     * @param end   конец периода
     * @param uris  список URI для фильтрации (может быть null)
     * @return список DTO со статистикой
     */
    @Query("""
        SELECT new ru.practicum.ViewStatsDto(e.app, e.uri, COUNT(e))
        FROM EndpointHit e
        WHERE e.timestamp BETWEEN :start AND :end
        AND (:uris IS NULL OR e.uri IN :uris)
        GROUP BY e.app, e.uri
        ORDER BY COUNT(e) DESC
        """)
    List<ViewStatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris);
}