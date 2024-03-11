package com.project.gestao_vagas.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandlerController {

    private MessageSource messageSource;

    public ExceptionsHandlerController(MessageSource message){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        List<ErroMessageDTO> dto = new ArrayList<>();
        
        e.getBindingResult().getFieldErrors().forEach(err -> {
            @SuppressWarnings("null")
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());

            ErroMessageDTO erro = new ErroMessageDTO(message, err.getField());
            dto.add(erro);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
