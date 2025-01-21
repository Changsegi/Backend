package hu.me.iit.storage.mappers;

import hu.me.iit.storage.dtos.OwnerDto;
import hu.me.iit.storage.entities.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface OwnerMapper {
    Owner toOwner(OwnerDto ownerDto);
    OwnerDto toOwnerDto(Owner owner);
    List<OwnerDto> toOwnerDtos(List<Owner> owners);
}
