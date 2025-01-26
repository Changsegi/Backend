package hu.me.iit.storage.controllers;


import hu.me.iit.storage.dtos.PlaneDto;
import hu.me.iit.storage.services.PlanesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
public class PlanesController {
    private final PlanesService planesService;

    @GetMapping( "/planes")
    public ResponseEntity<List<PlaneDto>> allPlanes() {
        return ResponseEntity.ok(planesService.allPlanes());
    }

    @GetMapping("/planes/{id}")
    public ResponseEntity<PlaneDto> getPlane(@PathVariable Long id) {
        return ResponseEntity.ok(planesService.getPlane(id));
    }

    @PostMapping("/planes")
    public ResponseEntity<PlaneDto> createPlane(@Valid @RequestBody PlaneDto planeDto) {
        PlaneDto createdPlane = planesService.createPlane(planeDto);
        return ResponseEntity.ok(createdPlane);
    }

    @PutMapping("/planes/{id}")
    public ResponseEntity<PlaneDto> updatePlane(@PathVariable Long id, @Valid @RequestBody PlaneDto planeDto) {
        PlaneDto updatedPlane = planesService.updatePlane(id, planeDto);
        return ResponseEntity.ok(updatedPlane);
    }

    @DeleteMapping("/planes/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        planesService.deletePlane(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/planes/")
    public ResponseEntity<Void> deletePlanes() {
        planesService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
