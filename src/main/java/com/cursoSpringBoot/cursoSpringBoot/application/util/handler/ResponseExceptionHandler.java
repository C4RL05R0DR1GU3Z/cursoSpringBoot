package com.cursoSpringBoot.cursoSpringBoot.application.util.handler;

import com.cursoSpringBoot.cursoSpringBoot.application.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDto>handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex){
        ResponseDto errorResponse = new ResponseDto();
        errorResponse.setCode("03");
        errorResponse.setMessagge("Error en los parametros de entrada");

        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            Map<String,String> errorsField = new HashMap<>();
            errorsField.put(fieldError.getField(),fieldError.getDefaultMessage());
            errorResponse.setData(errorsField);
        }
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
