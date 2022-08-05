package com.leoscode.ratingsdataservice.resource;

import com.leoscode.ratingsdataservice.model.Rating;
import com.leoscode.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingResource {
@RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId")String movieId){

        return new Rating(movieId,7);
    }

    @RequestMapping("user/{userId}")
    public UserRating getUserRating(@PathVariable("userId")String userId){
        List<Rating> ratings =Arrays.asList(
                new Rating("14242",9),
                new Rating("6565",14)
                );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;

    }

}
