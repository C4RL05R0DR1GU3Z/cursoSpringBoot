package com.cursoSpringBoot.cursoSpringBoot.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDto <T>{

    private String code;
    private String messagge;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
