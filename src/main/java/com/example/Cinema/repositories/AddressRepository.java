package com.example.Cinema.repositories;

import com.example.Cinema.model.Address;
import com.example.Cinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByUser(User user);

    List<Address> findByStreetName(String streetName);
}
