package com.cursoSpringBoot.cursoSpringBoot.application.Service;

import com.cursoSpringBoot.cursoSpringBoot.application.dto.ItemCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ResponseDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ShoppingCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.entities.Recibo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ShoppingCarService {
    ResponseDto getShoppingCarById(int id);

    ResponseDto createShoppingCar(ShoppingCarDto shoppingCar);

    ResponseDto updateShoppingCarByItem(ItemCarDto itemCarDto);

    ResponseDto deleteShoppingCarById(int id);

    List<Recibo> getAll();

    List<Recibo> getByDescripcion(String descripcion);


}
