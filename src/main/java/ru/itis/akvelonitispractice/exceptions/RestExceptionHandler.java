package ru.itis.akvelonitispractice.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itis.akvelonitispractice.models.ErrorMessage;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    protected ResponseEntity<String> projectNotFound(ProjectNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder().error(ex.getMessage()).build();
        try {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectMapper.writeValueAsString(errorMessage));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @ExceptionHandler(TaskNotFoundException.class)
    protected ResponseEntity<String> taskNotFound(TaskNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder().error(ex.getMessage()).build();
        try {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectMapper.writeValueAsString(errorMessage));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<String> invalid(IllegalArgumentException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder().error(ex.getMessage()).build();
        try {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(errorMessage));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
