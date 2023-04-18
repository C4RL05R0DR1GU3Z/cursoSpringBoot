package com.cursoSpringBoot.cursoSpringBoot.application.Service;

import com.cursoSpringBoot.cursoSpringBoot.application.dto.ItemCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ResponseDto;
import com.cursoSpringBoot.cursoSpringBoot.application.dto.ShoppingCarDto;
import com.cursoSpringBoot.cursoSpringBoot.application.entities.Car;
import com.cursoSpringBoot.cursoSpringBoot.application.entities.Recibo;
import com.cursoSpringBoot.cursoSpringBoot.application.entities.Venta;
import com.cursoSpringBoot.cursoSpringBoot.application.repository.IReciboRepository;
import com.cursoSpringBoot.cursoSpringBoot.application.utils.ShoppingCarUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCarImplementation implements ShoppingCarService {

    private ShoppingCarUtils shoppingCarUtils;

    private IReciboRepository reciboRepository;

    @Override
    public ResponseDto getShoppingCarById(int id) {
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {

            responseDto.setCode("00");
            responseDto.setMessagge("OK");
            ItemCarDto itemcarDto = new ItemCarDto("carro", 1, 2.1, "campero");
            List<ItemCarDto> list = new ArrayList<>();
            list.add(itemcarDto);
            ShoppingCarDto shoppingcarDto = new ShoppingCarDto("1", list);
            responseDto.setData(shoppingcarDto);

            response = new ResponseEntity(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            responseDto.setCode("01");
            responseDto.setMessagge("Ningun Item corresponde con el parametro ingresado");
            response = new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }

        return responseDto;

    }

    @Override
    public ResponseDto createShoppingCar(ShoppingCarDto shoppingCar) {
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            Car carItem;
            List<Car> items = new ArrayList<>();
            Venta venta;
            List<Venta> ventas = new ArrayList<>();
            Recibo recibo = new Recibo();
            recibo.setNombre("Pepito Perez");
            for (ItemCarDto itemsCar : shoppingCar.getItems()) {
                carItem = new Car();
                carItem.setName(itemsCar.getName());
                carItem.setPrice(itemsCar.getPrice());
                items.add(carItem);
                venta = new Venta();
                venta.setAmount(itemsCar.getAmount());
                venta.setDescription(itemsCar.getDescription());
                venta.setCars(items);
                ventas.add(venta);
            }
            recibo.setVentas(ventas);


            reciboRepository.save(recibo);

            responseDto.setCode("00");
            responseDto.setMessagge("Objeto creado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
            shoppingCarUtils.converFromDollarToCop(shoppingCar.getItems().get(0).getPrice());

        } catch (Exception e) {
            responseDto.setCode("02");
            responseDto.setMessagge("Error al crear el objeto, valida nuevamente");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseDto;
    }

    @Override
    public ResponseDto updateShoppingCarByItem(ItemCarDto itemCarDto) {
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessagge("Objeto actualizado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            responseDto.setCode("02");
            responseDto.setMessagge("Error al actualizar el objeto, valida nuevamente");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseDto;
    }

    @Override
    public ResponseDto deleteShoppingCarById(int id) {
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessagge("Objeto eliminado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            responseDto.setCode("02");
            responseDto.setMessagge("Error al eliminar el objeto, valida nuevamente");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseDto;
    }

    public List<Recibo> getAll() {
        return reciboRepository.findAll();
    }

    public List<Recibo> getByDescripcion(String descripcion) {
        return reciboRepository.findByDescription(descripcion);
    }

}
