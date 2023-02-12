package com.nyaka.bank.service.impl;

import com.nyaka.bank.dto.AddressDto;
import com.nyaka.bank.entity.AddressBank;
import com.nyaka.bank.repository.AddressBankRepository;
import com.nyaka.bank.service.AddressService;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;

import com.nyaka.bank.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressBankRepository repository;
    private ObjectsValidator<AddressDto> validator;

    @Override
    public Integer save(AddressDto dto) {
        validator.validate(dto);
        AddressBank address = AddressDto.toEntity(dto);
        return repository.save(address).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AddressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Integer id) {
        return repository.findById(id)
                .map(AddressDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No address found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check delete
        repository.deleteById(id);
    }
}
