package com.williammiranda.workshop.mongodb.resources.exception;

import com.williammiranda.workshop.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError standarError = new StandarError(System.currentTimeMillis(), status.value(), "Não encontrado!", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standarError);
    }
}
