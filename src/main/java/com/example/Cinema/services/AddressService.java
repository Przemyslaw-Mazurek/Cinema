package com.example.Cinema.services;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Address;
import com.example.Cinema.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class AddressService {

    //private final SystemProperties systemProperties;
    private final AddressRepository addressRepository;

    private final String addressNotFound = "Address with id = {0} not found.";
    private final String addressWithStreetNameNotFound = "Address with name of the street ,, {0} '' not found.";

    public AddressService( AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public List<Address> getAllAddressesByStreetName(String streetName){
        List<Address> addresses = addressRepository.findByStreetName(streetName);

        if (addresses.isEmpty()){
            throw new NoSuchElementFoundException(MessageFormat.format(addressWithStreetNameNotFound, streetName));
        }

        return addresses;
    }

    public Address saveAddress(Address address){
       return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(addressNotFound, id)));
        return address;
    }

    public Address updateAddress(Long id, Address address) {
        Address newAddress = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(addressNotFound, id)));

        newAddress.setStreetName(address.getStreetName());
        newAddress.setBlockNumber(address.getBlockNumber());
        newAddress.setApartmentNumber(address.getApartmentNumber());
        newAddress.setPostCode(address.getPostCode());
        newAddress.setCountry(address.getCountry());
        newAddress.setCity(address.getCity());

        return addressRepository.save(newAddress);
    }

    public void removeAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(addressNotFound, id)));
        addressRepository.deleteById(id);
    }


}
