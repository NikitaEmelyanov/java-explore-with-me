package ru.practicum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.CreateEndpointHitDto;
import ru.practicum.model.EndpointHit;

/**
 * Маппер для преобразования между DTO и сущностью EndpointHit.
 */
@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    /**
     * Преобразует CreateEndpointHitDto в EndpointHit.
     *
     * @param request DTO для создания записи
     * @return сущность EndpointHit
     */
    @Mapping(target = "id", ignore = true)
    EndpointHit fromNewRequest(CreateEndpointHitDto request);
}