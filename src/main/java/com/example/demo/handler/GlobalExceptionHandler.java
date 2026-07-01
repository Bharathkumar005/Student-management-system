package com.example.demo.handler;

import com.example.demo.exception.StudentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Method;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String>handleStudentsNotFound(StudentNotFoundException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> HandleValidation(MethodArgumentNotValidException ex){
        String error= ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(error);
    }
}
