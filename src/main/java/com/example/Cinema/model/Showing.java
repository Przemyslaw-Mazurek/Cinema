package com.example.Cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Showing { // Séance

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showing_id")
    private Integer id;

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY) //
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "showing_time_slot",
            joinColumns = @JoinColumn(name = "showing_id"),
            inverseJoinColumns = @JoinColumn(name = "time_slot_id"))
    private List<TimeSlot> timeSlots;

//todo is this needed?
    @ManyToOne(cascade = {}, fetch = FetchType.LAZY)
    @JoinColumn(name = "repertoire_id")
    private Repertoire repertoire;

    @OneToOne(mappedBy = "showing")
    private Ticket ticket;

}
