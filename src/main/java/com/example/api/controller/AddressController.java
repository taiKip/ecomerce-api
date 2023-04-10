package com.example.api.controller;

import com.example.api.entity.Address;
import com.example.api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
return  ResponseEntity.ok(addressService.createAddress(address));
    }
}
