package com.example.Cinema.repositories;

import com.example.Cinema.model.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {

    CinemaRoom findByRoomNumber(Long roomNumber);


}
