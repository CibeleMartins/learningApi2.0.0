package br.com.learningapi.learningapi.handler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.learningapi.learningapi.common.ConvertDate;
import br.com.learningapi.learningapi.domain.exception.ResourceBadRequestException;
import br.com.learningapi.learningapi.domain.exception.ResourceNotFoundException;
import br.com.learningapi.learningapi.domain.model.ErrorMessageResponse;

@ControllerAdvice
public class RestExceptionHandler {

    // essa anotação diz ao spring boot só chamar esse método quando a exceção
    // ocorrida for a indicada em seu parametro
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handlerResourceNotFoundException(ResourceNotFoundException exception) {

        String dateHour = ConvertDate.convertDateForDateHour(new Date());

        ErrorMessageResponse error = new ErrorMessageResponse(dateHour, HttpStatus.NOT_FOUND.value(), "Not Found",exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorMessageResponse> handlerResourceBadRequestException(ResourceBadRequestException exception) {

        String dateHour = ConvertDate.convertDateForDateHour(new Date());

        ErrorMessageResponse error = new ErrorMessageResponse(dateHour, HttpStatus.BAD_REQUEST.value(), "Bad Request",exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageResponse> handlerResourceInternalServerErrorException(Exception exception) {

        String dateHour = ConvertDate.convertDateForDateHour(new Date());

        ErrorMessageResponse error = new ErrorMessageResponse(dateHour, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error",exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}