package com.example.Cinema.services;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.CinemaRoom;
import com.example.Cinema.repositories.CinemaRoomRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class CinemaRoomService {

    private final CinemaRoomRepository cinemaRoomRepository;
   // private final SystemProperties systemProperties;

    private final String cinemaRoomNotFound = "Cinema room with id = {0} not found.";

    public CinemaRoomService(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    public List<CinemaRoom> getAllCinemaRooms() {
        return cinemaRoomRepository.findAll();
    }
    public void removeCinemaRoom(Integer id) {
        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(cinemaRoomNotFound, id)));

        cinemaRoomRepository.delete(cinemaRoom);
    }

    public CinemaRoom getCinemaRoomById(Long cinemaRoomNr){
        return cinemaRoomRepository.findByRoomNumber(cinemaRoomNr);
    }
    public CinemaRoom getCinemaRoomById(Integer id) {
        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(cinemaRoomNotFound, id)));
        return cinemaRoom;
    }

    public CinemaRoom updateCinemaRoom(Integer id, CinemaRoom cinemaRoom) {
        CinemaRoom newCinemaRoom = cinemaRoomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(cinemaRoomNotFound, id)));

        newCinemaRoom.setCapacity(cinemaRoom.getCapacity());
        newCinemaRoom.setSeats(cinemaRoom.getSeats());
        return cinemaRoomRepository.save(newCinemaRoom);
    }

}
