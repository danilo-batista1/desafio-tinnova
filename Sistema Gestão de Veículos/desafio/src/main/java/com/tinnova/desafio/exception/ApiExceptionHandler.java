package com.tinnova.desafio.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@AllArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handlerBusinessException(BusinessException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .status(status.value())
                .path(request.getRequestURI())
                .statusDescription(status.getReasonPhrase())
                .method(request.getMethod())
                .timestamp(OffsetDateTime.now())
                .build();

        return ResponseEntity.status(status).body(errorMessage);
    }

}
