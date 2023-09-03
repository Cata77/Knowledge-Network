package com.knowledge_network.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionUserNotFoundHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("User not found!");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionSubjectNotFoundHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Course not found!");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
