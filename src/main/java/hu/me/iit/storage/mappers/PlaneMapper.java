package hu.me.iit.storage.mappers;

import hu.me.iit.storage.dtos.PlaneDto;
import hu.me.iit.storage.entities.Plane;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaneMapper {
    Plane toPlane(PlaneDto planeDto);
    PlaneDto toPlaneDto(Plane plane);
    List<PlaneDto> toPlaneDtos(List<Plane> planes);
}
