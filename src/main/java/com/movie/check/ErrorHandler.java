package com.movie.check;

import com.movie.check.configuration.customError.MovieNotFoundException;
import com.movie.check.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ApiResponse<HttpStatus> movieNotFound() {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST, "영화를 찾을 수 없습니다.");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse<HttpStatus> apiRequestException() {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST, "API 요청이 잘못되었습니다.");
    }


}
