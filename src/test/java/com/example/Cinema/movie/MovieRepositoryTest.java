package com.example.Cinema.movie;

import com.example.Cinema.enums.MovieCategory;
import com.example.Cinema.model.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

    @BeforeEach
    public void setUpMoviesAndSavingToDB() {
        movieRepository.deleteAll();

        movie1 = new Movie(1L, "Harry Potter", 180, "description"
                , 12, 9.8, false, MovieCategory.FANTASY);
        movie2 = new Movie(2l, "Shrek", 150, "desc"
                , 12, 9.2, true, MovieCategory.FANTASY);
        movie3 = new Movie(3l, "Swiat wedlug kiepskich", 50, "desc"
                , 16, 8.7, true, MovieCategory.COMEDY);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
    }

    /*@Test
    public void verifyItReturnsListWithSpecificMovieCategory() {
        //given
        MovieCategory movieCategoryWithFantasy = MovieCategory.FANTASY;
        //when
        List<Movie> moviesWithFantasyCategory = movieRepository.findMovieByMovieCategory()
        //then
        assertThat(moviesWithFantasyCategory.size(), equalTo(2));
    }*/
}
