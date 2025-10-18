package ru.practicum.compilation.dto;

import java.util.Set;
import ru.practicum.event.dto.EventShortDto;

public record CompilationDto(
    Long id,

    Set<EventShortDto> events,

    boolean pinned,

    String title
) {

}
