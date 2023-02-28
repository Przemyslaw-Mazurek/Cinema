package com.example.Cinema.model;

import com.example.Cinema.enums.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "seats")
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer seatNumber;

    public Seat(Integer seatNumber, SeatType seatType, CinemaRoom cinemaRoom) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.cinemaRoom = cinemaRoom;
    }

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne()
    @JoinColumn(name = "cinema_room_id" )
    private CinemaRoom cinemaRoom;

}
