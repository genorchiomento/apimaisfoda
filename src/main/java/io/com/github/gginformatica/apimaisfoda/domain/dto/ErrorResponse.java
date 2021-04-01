package io.com.github.gginformatica.apimaisfoda.domain.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private final LocalDateTime date;
    private final String path;
    private final Integer statusCode;
    private final String error;
    private final String message;

    public ErrorResponse(LocalDateTime date, String path, Integer statusCode, String error, String message) {
        this.date = date;
        this.path = path;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
