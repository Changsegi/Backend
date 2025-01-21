package hu.me.iit.storage.services;

import hu.me.iit.storage.dtos.PlaneDto;
import hu.me.iit.storage.entities.Plane;
import hu.me.iit.storage.exceptions.AppException;
import hu.me.iit.storage.mappers.PlaneMapper;
import hu.me.iit.storage.repositories.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanesService {

    private final PlaneRepository planeRepository;
    private final PlaneMapper mapper;

    public List<PlaneDto> allPlanes() {
        List<Plane> all = planeRepository.findAll();
        return mapper.toPlaneDtos(all);
    }

    public PlaneDto getPlane(Long id) {

        Plane plane = planeRepository.findById(id)
                .orElseThrow(() -> new AppException("Plane not found", HttpStatus.NOT_FOUND));
        return mapper.toPlaneDto(plane);
    }

    public PlaneDto createPlane(PlaneDto planeDto) {
        Plane plane = mapper.toPlane(planeDto);
        Plane createdPlane = planeRepository.save(plane);
        return mapper.toPlaneDto(createdPlane);
    }

    public PlaneDto updatePlane(Long id, PlaneDto planeDto) {
        Plane plane = mapper.toPlane(planeDto);
        Plane storedPlane = planeRepository.findById(id).orElseThrow( () -> new AppException("Plane not found", HttpStatus.NOT_FOUND));
        plane.setId(storedPlane.getId());
        Plane updatedPlane = planeRepository.save(plane);
        return mapper.toPlaneDto(updatedPlane);
    }

    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }

    public void deleteAll() {
        planeRepository.deleteAll();
    }
}
