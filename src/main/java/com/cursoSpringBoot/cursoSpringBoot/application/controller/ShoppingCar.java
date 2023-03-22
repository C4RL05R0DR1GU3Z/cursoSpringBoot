package com.cursoSpringBoot.cursoSpringBoot.application.controller;

import com.cursoSpringBoot.cursoSpringBoot.application.dto.ItemCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ResponseDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ShoppingCarDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCar {

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getShoppingCarById(@PathVariable(required = true)@Min(1) int id){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {

            responseDto.setCode("00");
            responseDto.setMessagge("OK");
            ItemCarDto itemcarDto = new ItemCarDto("carro",1,2.1, "campero");
            List<ItemCarDto> list = new ArrayList<>();
            list.add(itemcarDto);
            ShoppingCarDto shoppingcarDto = new ShoppingCarDto("1",list );
            responseDto.setData(shoppingcarDto);
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("01");
            responseDto.setMessagge("Ningun Item corresponde con el parametro ingresado");
            response = new ResponseEntity<>(responseDto,HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @PostMapping()
    public ResponseEntity<ResponseDto> createShoppingCar(@Valid @RequestBody ShoppingCarDto shoppingcarDto){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessagge("Objeto creado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessagge("Error al crear el objeto, valida nuevamente");
            response = new ResponseEntity<>(responseDto,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;

    }

    @PutMapping()
    public ResponseEntity<ResponseDto> updateShoppingCarByItem(@Valid @RequestBody ItemCarDto itemcarDto){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessagge("Objeto actualizado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessagge("Error al actualizar el objeto, valida nuevamente");
            response = new ResponseEntity<>(responseDto,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteShoppingCar(@PathVariable(required = true)@Min(1) int id){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessagge("Objeto eliminado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessagge("Error al eliminar el objeto, valida nuevamente");
            response = new ResponseEntity<>(responseDto,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;

    }
}
