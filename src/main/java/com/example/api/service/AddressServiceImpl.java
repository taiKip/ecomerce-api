package com.example.api.service;

import com.example.api.entity.Address;
import com.example.api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;
    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
}
