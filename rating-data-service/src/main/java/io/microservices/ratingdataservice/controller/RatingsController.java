package io.microservices.ratingdataservice.controller;

import io.microservices.ratingdataservice.model.Ratings;
import io.microservices.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {
    @GetMapping("/{movieId}")
    public Ratings getRatings(@PathVariable("movieId") String movieId){
        return new Ratings(movieId,4);
    }

    @GetMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        List<Ratings> ratings= Arrays.asList(
                new Ratings("1234",4),
                new Ratings("5678",5)

        );

        UserRating userRating=new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
