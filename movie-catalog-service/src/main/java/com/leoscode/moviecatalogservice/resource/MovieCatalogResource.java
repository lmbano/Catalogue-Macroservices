package com.leoscode.moviecatalogservice.resource;

import com.leoscode.moviecatalogservice.model.CatalogItem;
import com.leoscode.moviecatalogservice.model.Movie;
import com.leoscode.moviecatalogservice.model.Rating;
import com.leoscode.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerWebClientBuilderBeanPostProcessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
@Autowired
  private   RestTemplate restTemplate ;

@Autowired
private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable ("userId") String userId){

      //  UserRating ratings= restTemplate.getForObject("http://localhost:8087/rating/user/" + userId, UserRating.class);

        UserRating ratings= restTemplate.getForObject("http://movie-rating-service/rating/user/" + userId, UserRating.class);
       return ratings.getUserRating().stream().map(rating -> {

          // Using WebClient Builder
            /*  Movie movie =      webClientBuilder.build()
                   .get()
                   .uri("http://localhost:8088/movies/" + rating.getMovieId())
                   .retrieve()
                   .bodyToMono(Movie.class)
                   .block();
            */
            // Using RestTamplate
          // Movie movie = restTemplate.getForObject("http://localhost:8088/movies/" + rating.getMovieId(), Movie.class);
          Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
           return new CatalogItem(movie.getName(), "Animation", rating.getRating());

       })
                .collect(Collectors.toList());
    }

}
