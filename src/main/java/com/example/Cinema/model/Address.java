package com.example.Cinema.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String streetName;

    @NotBlank
    @Column(name = "block_number")
    private String blockNumber;

    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    @NotBlank
    @Column(name = "post_code")
    private String postCode;

    @NotBlank
    private String country;

    @OneToOne(mappedBy = "address")
    private User user;


}
