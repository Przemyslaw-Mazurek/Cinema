package com.example.Cinema.repositories;

import com.example.Cinema.enums.Role;
import com.example.Cinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstNameAndLastNameEqualsIgnoreCase(String firstName, String lastName);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAllByRole(Role role);
}
