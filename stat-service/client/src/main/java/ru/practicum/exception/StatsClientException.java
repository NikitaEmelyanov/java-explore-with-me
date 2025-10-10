package ru.practicum.exception;

/**
 * Исключение для клиента статистики. Выбрасывается при ошибках взаимодействия с сервисом
 * статистики.
 */
public class StatsClientException extends RuntimeException {

    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param cause   причина исключения
     */
    public StatsClientException(String message, Throwable cause) {
        super(message, cause);
    }
}