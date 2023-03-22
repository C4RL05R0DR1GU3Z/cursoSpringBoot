package com.cursoSpringBoot.cursoSpringBoot.application.Service;

import com.cursoSpringBoot.cursoSpringBoot.application.dto.ResponseDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ShoppingCarDto;

public interface ShoppingCarService {
    ResponseDto getShoppingCarById(int id);

    ResponseDto createShoppingCar(ShoppingCarDto shoppingcarDto);
}
