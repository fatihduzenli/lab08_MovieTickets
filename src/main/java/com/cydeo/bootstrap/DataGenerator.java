package com.cydeo.bootstrap;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Genre;
import com.cydeo.entity.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import com.cydeo.repository.CinemaRepository;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.LocationRepository;
import com.cydeo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cydeo.enums.State.ACTIVE;
import static com.cydeo.enums.Type.PREMIER;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final CinemaRepository cinemaRepository;
    private final LocationRepository locationRepository;

    @Override
    public void run(String... args) throws Exception {


        Movie movie = new Movie(
                "Terminator",
                new BigDecimal("25"),
                PREMIER,
                ACTIVE,
                LocalDate.of(2020, 12, 20),
                120,
                "Great Movie",
                new ArrayList<>(Arrays.asList(
                        genreRepository.getReferenceById(1L),
                        genreRepository.getReferenceById(2L),
                        genreRepository.getReferenceById(3L)
                ))
        );

        movieRepository.save(movie);

        Cinema cinema= new Cinema("Regal","Amazon",locationRepository.getReferenceById(1L));
        cinemaRepository.save(cinema);



    }

}
