package com.example.Cinema.movie;

import com.example.Cinema.MoviePaging;
import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Movie;
import com.example.Cinema.repositories.MovieRepository;
import com.example.Cinema.services.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;
    @InjectMocks
    private MovieService movieService;


    @Test
    public void verifyThrowsExceptionWhenMovieByIdNotFound() {
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
