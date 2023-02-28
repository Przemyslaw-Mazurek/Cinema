package com.example.Cinema.model;

import com.example.Cinema.enums.MovieCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    public Movie(String title, int duration, String description, int minimumAge, double rating, boolean isPremiere, MovieCategory movieCategory) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.minimumAge = minimumAge;
        this.rating = rating;
        this.isPremiere = isPremiere;
        this.movieCategory = movieCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private int duration;

    private String description;

    @NotNull
    @Column(name = "minimum_age")
    private int minimumAge;

    @NotNull
    private double rating;

    @NotNull
    @Column(name = "is_premiere")
    private boolean isPremiere;

    @Enumerated(EnumType.STRING)
    @Column(name = "movie_category")
    private MovieCategory movieCategory;

}
