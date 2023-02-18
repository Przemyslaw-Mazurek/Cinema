package com.example.Cinema.controllers;

import com.example.Cinema.model.Address;
import com.example.Cinema.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id){
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Address>> getAllAddressesByStreetName(@RequestParam(value = "streetName") String streetName){
       return ResponseEntity.ok(addressService.getAllAddressesByStreetName(streetName));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeAddress(Long id) {
        addressService.removeAddress(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody @Valid Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        return ResponseEntity.ok(updatedAddress);
    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@Valid @RequestBody Address address){
        return ResponseEntity.ok(addressService.saveAddress(address));
    }
}
