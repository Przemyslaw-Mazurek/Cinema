package com.example.Cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_room_id")
    private Integer id;

    @Column(name = "cinema_room_nr")
    @NotNull
    private Integer roomNumber;

    private Integer capacity;
    private Seat[][] seats;


}
