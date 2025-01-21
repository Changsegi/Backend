package hu.me.iit.storage.controllers;

import hu.me.iit.storage.dtos.OwnerDto;
import hu.me.iit.storage.services.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class OwnersController {

    private final OwnerService ownerService;

    @GetMapping("/owners")
    public ResponseEntity<List<OwnerDto>> allOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.getOwner(id));
    }

    @PostMapping("/owners")
    public ResponseEntity<OwnerDto> createOwner(@Valid @RequestBody OwnerDto ownerDto) {
        OwnerDto createdOwner = ownerService.createOwner(ownerDto);
        return ResponseEntity.created(URI.create("/owners/" + createdOwner.getId())).body(createdOwner);
    }

    @PutMapping("/owners/{id}")
    public ResponseEntity<OwnerDto> updateOwner(@PathVariable Long id, @Valid @RequestBody OwnerDto ownerDto) {
        OwnerDto updateOwner = ownerService.updateOwner(id, ownerDto);
        return ResponseEntity.ok(updateOwner);
    }

    @DeleteMapping("/owners/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/owners/")
    public ResponseEntity<Void> deleteOwners() {
        ownerService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
