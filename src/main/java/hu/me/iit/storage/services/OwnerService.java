package hu.me.iit.storage.services;

import hu.me.iit.storage.dtos.OwnerDto;
import hu.me.iit.storage.entities.Owner;
import hu.me.iit.storage.exceptions.AppException;
import hu.me.iit.storage.mappers.OwnerMapper;
import hu.me.iit.storage.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public List<OwnerDto> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return ownerMapper.toOwnerDtos(owners);
    }

    public OwnerDto getOwner(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new AppException("Owner not found", HttpStatus.NOT_FOUND));
        return ownerMapper.toOwnerDto(owner);
    }

    public OwnerDto createOwner(OwnerDto ownerDto) {
        Owner owner = ownerMapper.toOwner(ownerDto);
        Owner createOwner = ownerRepository.save(owner);
        return ownerMapper.toOwnerDto(createOwner);
    }

    public OwnerDto updateOwner(Long id, OwnerDto ownerDto) {
        Owner owner = ownerMapper.toOwner(ownerDto);
        Owner storedOwner = ownerRepository.findById(id).orElseThrow(() -> new AppException("Owner not found", HttpStatus.NOT_FOUND));
        owner.setId(storedOwner.getId());
        Owner updatedOwner = ownerRepository.save(owner);
        return ownerMapper.toOwnerDto(updatedOwner);
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    public void deleteAll() {
        ownerRepository.deleteAll();
    }
}
