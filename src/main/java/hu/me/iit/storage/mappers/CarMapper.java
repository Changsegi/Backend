package hu.me.iit.storage.mappers;

import hu.me.iit.storage.dtos.CarDto;
import hu.me.iit.storage.entities.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car toCar(CarDto carDto);
    CarDto toCarDto(Car car);
    List<CarDto> toCarDtos(List<Car> cars);


}
