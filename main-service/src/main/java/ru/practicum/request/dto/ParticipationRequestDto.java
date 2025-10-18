package ru.practicum.request.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import ru.practicum.request.model.RequestStatus;

public record ParticipationRequestDto(
    Long id,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created,

    Long event,

    Long requester,

    RequestStatus status
) {

}