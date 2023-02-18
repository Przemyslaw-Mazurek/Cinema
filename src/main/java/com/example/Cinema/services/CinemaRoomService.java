package com.example.Cinema.services;

import com.example.Cinema.enums.SeatType;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.CinemaRoom;
import com.example.Cinema.model.Seat;
import com.example.Cinema.repositories.CinemaRoomRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaRoomService {

    private final CinemaRoomRepository cinemaRoomRepository;


    private final String cinemaRoomNotFound = "Cinema room with id = {0} not found.";

    public CinemaRoomService(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    public void addCinemaRoom(CinemaRoom cinemaRoom, List<Seat> seats) {
        cinemaRoom.setSeats(seats);
        cinemaRoomRepository.save(cinemaRoom);
    }

    @PostConstruct
    public void initializeCinemaRoomBySeats() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomNumber(1);
        cinemaRoom.setCapacity(200);

        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i <= 200; i++) {
            if (i <= 170) {
                seats.add(new Seat(i, SeatType.NORMAL, cinemaRoom));
            } else if (i < 190) {
                seats.add(new Seat(i, SeatType.VIP, cinemaRoom));
            } else {
                seats.add(new Seat(i, SeatType.DISABLED, cinemaRoom));
            }
        }

        addCinemaRoom(cinemaRoom, seats);
    }

    public List<CinemaRoom> getAllCinemaRooms() {
        return cinemaRoomRepository.findAll();
    }

    public void removeCinemaRoom(Integer id) {
        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(cinemaRoomNotFound, id)));

        cinemaRoomRepository.delete(cinemaRoom);
    }

    public CinemaRoom getCinemaRoomById(Long cinemaRoomNr) {
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
