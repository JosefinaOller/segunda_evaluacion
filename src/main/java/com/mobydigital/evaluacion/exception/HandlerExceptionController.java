package com.mobydigital.evaluacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<String> handleRecursoNoEncontrado(RecursoNoEncontradoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatoInvalidoException.class)
    public ResponseEntity<String> handleDatoInvalido(DatoInvalidoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
