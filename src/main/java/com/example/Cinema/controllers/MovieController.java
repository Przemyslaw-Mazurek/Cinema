package com.example.Cinema.controllers;

import com.example.Cinema.MoviePaging;
import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.model.Movie;
import com.example.Cinema.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {


    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getMoviesWithPage());
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Movie>> getMoviesPage(MoviePaging moviePaging){
        return ResponseEntity.ok(movieService.getMoviesWithPage());
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeMovie(Long id) {
        movieService.removeMovie(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @Valid @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }
}
