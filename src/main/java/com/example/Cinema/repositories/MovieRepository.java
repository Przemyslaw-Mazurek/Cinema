package com.example.Cinema.repositories;

import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    //List<Movie> findMovieByMovieCategory_ScienceFiction

    List<Movie> findMovieByMovieCategory(MovieCategory movieCategory, Pageable pageable);




    //TODO dodać filtrowanie i paginacje


}
