package com.example.Cinema.address;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Address;
import com.example.Cinema.model.User;
import com.example.Cinema.repositories.AddressRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepositoryTest;


    @AfterEach
    void tearDown() {
        addressRepositoryTest.deleteAll();
    }

    @BeforeEach
    public void clearDB() {
        addressRepositoryTest.deleteAll();
    }

    @Test
    public void verifyItReturnsListAddressesByStreetName() {
        //given
        String exampleStreetNameToFind = "Cybernetyki";

        Address address1 = new Address(1L, "Cybernetyki", "17C", 9, "12-127", "Poland", null);
        Address address2 = new Address(2L, "Uliczna", "21", 3, "44-127", "Poland", null);
        Address address3 = new Address(3L, "Cybernetyki", "9", 4, "02-677", "Poland", null);
        Address address4 = new Address(4L, "Cybernetyki", "11", 1, "03-677", "Poland", null);

        addressRepositoryTest.save(address1);
        addressRepositoryTest.save(address2);
        addressRepositoryTest.save(address3);
        addressRepositoryTest.save(address4);

        //when
        int listSize = addressRepositoryTest.findByStreetName(exampleStreetNameToFind).size();

        //then
        assertThat(listSize).isEqualTo(3);
    }

    @Test
    public void verifyRepositorySaveAddressToDB() {
        //given
        Address address = new Address(1L, "Cybernetyki", "17C", 9, "12-127", "Poland", null);
        addressRepositoryTest.save(address);

        //when
        List<Address> cybernetykiAddresses = addressRepositoryTest.findByStreetName("Cybernetyki");

        //then
        assertThat(cybernetykiAddresses.get(0)).isEqualTo(address);
    }


    @Test
    public void verifyItReturnsAddressByUser(){
        //given
        User user = new User();

    }


}
