package com.example.Cinema.controllers;

import com.example.Cinema.model.CinemaRoom;
import com.example.Cinema.services.CinemaRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cinemaRooms")
public class CinemaRoomController {
    private final CinemaRoomService cinemaRoomService;

    public CinemaRoomController(CinemaRoomService cinemaRoomService) {
        this.cinemaRoomService = cinemaRoomService;
    }

    @GetMapping
    public ResponseEntity<List<CinemaRoom>> getAllCinemaRooms(){
        List<CinemaRoom> allAddresses = cinemaRoomService.getAllCinemaRooms();
        return ResponseEntity.ok(allAddresses);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCinemaRoom(@PathVariable Integer id) {
        cinemaRoomService.removeCinemaRoom(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaRoom> getCinemaRoom(@PathVariable Integer id) {
        CinemaRoom cinemaRoom = cinemaRoomService.getCinemaRoomById(id);
        return ResponseEntity.ok(cinemaRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CinemaRoom> updateCinemaRoom(@PathVariable Integer id, @RequestBody @Valid CinemaRoom cinemaRoom){
        CinemaRoom newCinemaRoom = cinemaRoomService.updateCinemaRoom(id, cinemaRoom);
        return ResponseEntity.ok(newCinemaRoom);
    }
}
