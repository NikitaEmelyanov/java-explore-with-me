package ru.practicum.user.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import ru.practicum.user.dto.NewUserRequest;
import ru.practicum.user.dto.UserDto;
import ru.practicum.user.model.User;

public interface UserService {

    UserDto createUser(NewUserRequest userRequest);

    List<UserDto> getUsers(List<Long> ids, Pageable pageable);

    void deleteUser(Long userId);

    User getUserById(Long userId);

    User getUserByIdOrThrow(Long userId);
}