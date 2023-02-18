package com.example.Cinema.movie;

import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Movie;
import com.example.Cinema.repositories.MovieRepository;
import com.example.Cinema.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    private MovieService movieService;

    @BeforeEach
    public void setUpMovieService(){
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void verifyThrowsExceptionWhenMovieByIdNotFound(){
        //given
        movieRepository.deleteAll();
        Long movieID = 1L;
        Movie movie = new Movie(1L, "Harry Potter", 180, "description"
                , 12, 9.8, false, MovieCategory.FANTASY);

        //then
        assertThrows(NoSuchElementFoundException.class, () -> movieService.removeMovie(movieID));
        assertThrows(NoSuchElementFoundException.class, () -> movieService.getMovie(movieID));
        assertThrows(NoSuchElementFoundException.class, () -> movieService.updateMovie(movieID, movie));
    }
}
