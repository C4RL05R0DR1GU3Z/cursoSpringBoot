package com.cursoSpringBoot.cursoSpringBoot.application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ItemCarDto {
    @NotBlank(message = "Valor requerido")
    @NotEmpty(message = "Longitud de la cadena mayor a 0")
    @NotNull(message = "Valor requerido")
    private String name;

    @NotNull
    @Min(1)
    private int amount;

    @NotNull
    private Double price;


    @NotEmpty
    @NotNull
    private String description;
}
