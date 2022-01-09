package com.movie.check.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;
    private LocalDateTime creationDate;

    public static<T> ApiResponse<T> apiResponse(T data) {
        return new ApiResponse<>(data);
    }

    public static ApiResponse<HttpStatus> apiResponse(HttpStatus status, String message) {
        return new ApiResponse<>(status, message);
    }

    public ApiResponse(T data) {
        this.status = HttpStatus.OK.value();
        this.data = data;
        this.creationDate = LocalDateTime.now();
    }

    public ApiResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
        this.creationDate = LocalDateTime.now();
    }

}
