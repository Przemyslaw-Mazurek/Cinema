package com.example.Cinema.address;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.repositories.AddressRepository;
import com.example.Cinema.services.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    private AddressService addressService;

    @BeforeEach
    public void setUpAddressService(){
        addressService = new AddressService(addressRepository);
    }
    @Test
    void canGetAllAddresses() {
        //when
        addressService.getAllAddresses();
        //then
        verify(addressRepository).findAll();
    }

    @Test
    public void verifyThrowsExceptionWhenAddressNotFound() {
        addressRepository.deleteAll();
        assertThrows(NoSuchElementFoundException.class, () -> addressService.getAddressById(1L));
    }
}