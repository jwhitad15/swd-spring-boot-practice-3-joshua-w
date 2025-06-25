package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import org.springframework.web.bind.annotation.*;
import repositories.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public Movie getAllItems(@RequestBody Movie movie) {
        return (Movie) movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getItem(@PathVariable int movieId) {
        return (Movie) movieRepository.findById(movieId).orElse(null);
    }

    @PostMapping("/movies")
    public Movie addItem(@RequestBody Movie movie) {
        return (Movie) movieRepository.save(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateItem(@PathVariable int movieId, @RequestBody Movie movie) {
        movie.setMovieId(movieId);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteItem(@PathVariable int movieId) {
        movieRepository.deleteById(movieId);
    }

}
