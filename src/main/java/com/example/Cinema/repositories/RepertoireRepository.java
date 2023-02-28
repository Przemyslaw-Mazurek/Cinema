package com.example.Cinema.repositories;

import com.example.Cinema.model.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {

    Repertoire findRepertoireByRepertoireDate(LocalDate repertoireDate);
}
