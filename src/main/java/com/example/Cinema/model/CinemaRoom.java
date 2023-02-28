package com.example.Cinema.model;

import com.example.Cinema.enums.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cinema_rooms")
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_room_id")
    private Integer id;

    @Column(name = "cinema_room_nr")
    @NotNull
    private Integer roomNumber;

    private Integer participants;

    private Integer capacity;

    @Column(name = "is_full")
    private Boolean isFull;

    public CinemaRoom(Integer capacity) {
        this.capacity = capacity;

        switch (capacity) {
            case 220:
                initializeSeatsWithCapacity220();
                break;
            case 350:
                initializeSeatsWithCapacity350();
                break;
            case 400:
                initializeSeatsWithCapacity400();
        }
    }

    @OneToMany(mappedBy = "cinemaRoom"
            , cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();


    private void initializeSeatsWithCapacity220() {
        for (int i = 1; i <= capacity; i++) {
            if (i <= 20) {
                this.seats.add(new Seat(i, SeatType.DISABLED, this));
            } else if (i <= 170) {
                this.seats.add(new Seat(i, SeatType.NORMAL, this));
            } else {
                this.seats.add(new Seat(i, SeatType.VIP, this));
            }
        }
    }


    private void initializeSeatsWithCapacity350() {
        for (int i = 1; i <= capacity; i++) {
            if (i <= 20) {
                this.seats.add(new Seat(i, SeatType.DISABLED, this));
            } else if (i <= 300) {
                this.seats.add(new Seat(i, SeatType.NORMAL, this));
            } else {
                this.seats.add(new Seat(i, SeatType.VIP, this));
            }
        }
    }


    private void initializeSeatsWithCapacity400() {
        for (int i = 1; i <= capacity; i++) {
            if (i <= 20) {
                this.seats.add(new Seat(i, SeatType.DISABLED, this));
            } else if (i <= 380) {
                this.seats.add(new Seat(i, SeatType.NORMAL, this));
            } else {
                this.seats.add(new Seat(i, SeatType.VIP, this));
            }
        }
    }

}
