package com.cursojava.projetowebservice.resources.exceptions;

import com.cursojava.projetowebservice.services.exceptions.DatabaseException;
import com.cursojava.projetowebservice.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // permite criar um tratamento global de exceções para os seus Controllers
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // sempre que uma ResourceNotFoundException for lançada, execute este método
    public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err =  new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class) // sempre que uma ResourceNotFoundException for lançada, execute este método
    public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err =  new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
