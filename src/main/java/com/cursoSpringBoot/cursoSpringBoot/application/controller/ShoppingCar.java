package com.cursoSpringBoot.cursoSpringBoot.application.controller;

import com.cursoSpringBoot.cursoSpringBoot.application.Service.ShoppingCarService;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ItemCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ResponseDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ShoppingCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.entities.Recibo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
@AllArgsConstructor
public class ShoppingCar {

    private ShoppingCarService shoppingCarService;


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getShoppingCarById(@PathVariable(required = true)@Min(1) int id){

        return new ResponseEntity<>(shoppingCarService.getShoppingCarById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Recibo>>getAll(){
        return new ResponseEntity<>(shoppingCarService.getAll(), HttpStatus.OK);
    }

    @GetMapping("findByDescripcion/{descripcion}")
    public ResponseEntity<List<Recibo>> findByDescripcion(@PathVariable(required = true) String descripcion){
        return new ResponseEntity<>(shoppingCarService.getByDescripcion(descripcion),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> createShoppingCar(@Valid @RequestBody ShoppingCarDto shoppingCar){
        return new ResponseEntity<>(shoppingCarService.createShoppingCar(shoppingCar),HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity<ResponseDto> updateShoppingCarByItem(@Valid @RequestBody ItemCarDto itemCarDto){
        return new ResponseEntity<>(shoppingCarService.updateShoppingCarByItem(itemCarDto),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteShoppingCarById(@PathVariable(required = true)@Min(1) int id){
        return new ResponseEntity<>(shoppingCarService.deleteShoppingCarById(id),HttpStatus.OK);

    }
}
