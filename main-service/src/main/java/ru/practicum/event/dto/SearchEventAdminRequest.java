package ru.practicum.event.dto;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public record SearchEventAdminRequest(
    List<Long> users,

    List<String> states,

    List<Long> categories,

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime rangeStart,

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime rangeEnd,

    Integer from,

    Integer size
) {

}