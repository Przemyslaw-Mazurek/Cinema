package com.example.Cinema.model;

import com.example.Cinema.enums.TicketType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<Seat> seats;

    @OneToOne(cascade = CascadeType.ALL)
    private Showing showing;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

}
