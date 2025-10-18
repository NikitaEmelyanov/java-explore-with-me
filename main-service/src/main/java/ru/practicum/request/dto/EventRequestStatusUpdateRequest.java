package ru.practicum.request.dto;

import java.util.List;
import ru.practicum.request.model.RequestStatus;

public record EventRequestStatusUpdateRequest(
    List<Long> requestIds,
    RequestStatus status
) {

}