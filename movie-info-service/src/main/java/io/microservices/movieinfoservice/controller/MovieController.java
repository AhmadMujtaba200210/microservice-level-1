package io.microservices.movieinfoservice.controller;

import io.microservices.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @GetMapping("/{movieId}")
    public Movie gerMovieInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId,"Test Name");
    }
}
