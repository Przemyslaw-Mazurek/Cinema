package com.example.Cinema.services;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class MovieService {
    //private final SystemProperties systemProperties;
    private final MovieRepository movieRepository;

    private final String movieNotFound = "Movie with id = {0} not found.";

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id) {
        Movie movieFromDB = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(movieNotFound, id)));

        return movieFromDB;
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie movieFromDB = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(movieNotFound, id)));

        movieFromDB.setTitle(movie.getTitle());
        movieFromDB.setDuration(movie.getDuration());
        movieFromDB.setMovieCategory(movie.getMovieCategory());
        movieFromDB.setDescription(movie.getDescription());
        movieFromDB.setMinimumAge(movie.getMinimumAge());
        movieFromDB.setRating(movie.getRating());
        movieFromDB.setPremiere(movie.isPremiere());

        return movieFromDB;
    }

    public void removeMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(movieNotFound, id)));
        movieRepository.delete(movie);
    }

}
