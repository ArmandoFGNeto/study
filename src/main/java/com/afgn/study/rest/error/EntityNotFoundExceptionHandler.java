package com.afgn.study.rest.error;

import com.afgn.study.exception.EntityNotFoundException;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new EntityNotFoundResponse(), new HttpHeaders(),
                                       HttpStatus.NOT_FOUND, request);
    }

    private final class EntityNotFoundResponse {

        @JsonProperty
        private final String message = "Requested resource does not exist";

        public String getMessage() {
            return message;
        }
    }
}