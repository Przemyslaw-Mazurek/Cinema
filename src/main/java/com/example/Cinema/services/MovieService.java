package com.example.Cinema.services;

import com.example.Cinema.MoviePaging;
import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class MovieService {
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

    public Page<Movie> getMoviesWithPage(MovieCategory movieCategory, MoviePaging moviePaging){
        Sort sort = Sort.by(moviePaging.getSortDirection(), moviePaging.getSortBy());
        Pageable pageable = PageRequest.of(moviePaging.getPageSize(), moviePaging.getPageSize(), sort);
        List<Movie> movieByMovieCategory = movieRepository.findMovieByMovieCategory(movieCategory, pageable);
        Page<Movie> moviesPage = new PageImpl<>(movieByMovieCategory);
        return moviesPage;
    }

    //TODO dodać metodę pobierającą listę movies po category

    public void removeMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(movieNotFound, id)));
        movieRepository.delete(movie);
    }

}
