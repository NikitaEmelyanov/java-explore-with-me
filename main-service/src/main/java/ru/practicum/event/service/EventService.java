package ru.practicum.event.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import ru.practicum.event.dto.EventFullDto;
import ru.practicum.event.dto.EventShortDto;
import ru.practicum.event.dto.NewEventDto;
import ru.practicum.event.dto.SearchEventAdminRequest;
import ru.practicum.event.dto.SearchEventPublicRequest;
import ru.practicum.event.dto.UpdateEventAdminRequest;
import ru.practicum.event.dto.UpdateEventUserRequest;
import ru.practicum.event.model.Event;

public interface EventService {

    List<EventShortDto> getEvents(Long userId, Pageable pageable);

    EventFullDto createEvent(Long userId, NewEventDto newEventDto);

    EventFullDto getEvent(Long userId, Long eventId, String ip);

    EventFullDto updateEvent(Long userId, Long eventId, UpdateEventUserRequest request);

    Event getEventOrThrow(Long eventId);

    List<EventFullDto> getEventsAdmin(SearchEventAdminRequest request, Pageable pageable);

    EventFullDto updateEventAdmin(Long eventId, UpdateEventAdminRequest request);

    List<EventShortDto> getEventsPublic(SearchEventPublicRequest requestParams, Pageable pageable,
        String ip);

    EventFullDto getEventByIdPublic(Long eventId, String ip);
}