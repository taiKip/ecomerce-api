package com.example.api.service;

import com.example.api.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address createAddress(Address address);
}
