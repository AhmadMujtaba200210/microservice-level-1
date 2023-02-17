package io.microservices.moviecatalogservice.controller;

import io.microservices.moviecatalogservice.model.CatalogItem;
import io.microservices.moviecatalogservice.model.Movie;
import io.microservices.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResourceController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClient;

    @GetMapping("movies/{userID}")
    public List<CatalogItem> getCatalogItem(@PathVariable("userID") String userID) {

        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userID, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
           Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);
//            Movie movie= webClient.build()
//                    .get()
//                    .uri("http://localhost:8082/movie/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)//it is a reactive way to get response as an object( async object )
//                    .block();// we are blocking the execution till the object has completed its requirements
            return new CatalogItem(movie.getName(), "Description demo", rating.getRating());
        }).collect(Collectors.toList());
    }
}
