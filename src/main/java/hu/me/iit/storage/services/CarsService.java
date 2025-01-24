package hu.me.iit.storage.services;

import hu.me.iit.storage.dtos.CarDto;
import hu.me.iit.storage.entities.Car;
import hu.me.iit.storage.entities.Plane;
import hu.me.iit.storage.exceptions.AppException;
import hu.me.iit.storage.mappers.CarMapper;
import hu.me.iit.storage.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarsService {

    private final CarRepository carRepository;
    private final CarMapper mapper;

    public List<CarDto> allCars() {
        List<Car> all = carRepository.findAll();
        return mapper.toCarDtos(all);
    }

    public CarDto getCar(Long id) {

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new AppException("Car not found", HttpStatus.NOT_FOUND));
        return mapper.toCarDto(car);
    }

    public CarDto createCar(CarDto carDto) {
        Car car = mapper.toCar(carDto);
        Car createdCar = carRepository.save(car);
        return mapper.toCarDto(createdCar);
    }

    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = mapper.toCar(carDto);
        Car storedCar = carRepository.findById(id).orElseThrow( () -> new AppException("Plane not found", HttpStatus.NOT_FOUND));
        car.setId(storedCar.getId());
        Car updatedCar = carRepository.save(car);
        return mapper.toCarDto(updatedCar);
    }


    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public void deleteAll() {
        carRepository.deleteAll();
    }
}
