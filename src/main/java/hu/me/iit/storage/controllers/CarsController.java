package hu.me.iit.storage.controllers;

import hu.me.iit.storage.dtos.CarDto;
import hu.me.iit.storage.services.CarsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
public class CarsController {

    private final CarsService carsService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> allCars() {
        return ResponseEntity.ok(carsService.allCars());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carsService.getCar(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto carDto) {
        CarDto createdCar = carsService.createCar(carDto);
        return ResponseEntity.created(URI.create("/cars/" + createdCar.getId())).body(createdCar);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @Valid @RequestBody CarDto carDto) {
        CarDto updatedCar = carsService.updateCar(id, carDto);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carsService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cars/")
    public ResponseEntity<Void> deleteCars() {
        carsService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
