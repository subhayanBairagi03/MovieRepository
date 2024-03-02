package com.movie.ratingservice.service;

import org.springframework.stereotype.Service;

@Service
public class RatingService {
    public Float getRating(Integer movieId){
        return 5.0f;
    }
}
