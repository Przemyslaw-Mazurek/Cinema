package com.example.Cinema.repositories;

import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findAll(Pageable pageable);

    List<Movie> findByMovieCategory(String category);
}
