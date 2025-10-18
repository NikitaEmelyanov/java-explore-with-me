package ru.practicum.event.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.event.dto.EventFullDto;
import ru.practicum.event.dto.SearchEventAdminRequest;
import ru.practicum.event.dto.UpdateEventAdminRequest;
import ru.practicum.event.service.EventService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/events")
public class AdminEventController {

    private final EventService eventService;

    @GetMapping
    public List<EventFullDto> getEventsAdmin(
        @ModelAttribute @Valid SearchEventAdminRequest request) {
        int size = (request.size() != null && request.size() > 0) ? request.size() : 10;
        int from = request.from() != null ? request.from() : 0;
        PageRequest pageRequest = PageRequest.of(from / size, size);
        log.debug("Controller: getEventAdmin filters {}", request);
        return eventService.getEventsAdmin(request, pageRequest);
    }

    @PatchMapping("/{eventId}")
    public EventFullDto updateEventAdmin(
        @PathVariable @Positive Long eventId,
        @RequestBody @Valid UpdateEventAdminRequest request
    ) {
        log.debug("Controller: updateEventAdmin id={}, data {}", eventId, request);
        return eventService.updateEventAdmin(eventId, request);
    }
}