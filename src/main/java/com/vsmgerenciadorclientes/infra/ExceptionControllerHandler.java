package com.vsmgerenciadorclientes.infra;

import com.vsmgerenciadorclientes.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException ex){
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage(), "400", LocalDateTime.now());
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneral(Exception ex){
        ExceptionDTO exception = new ExceptionDTO(ex.getMessage(), "500", LocalDateTime.now());
        return ResponseEntity.internalServerError().body(exception);
    }
}
