package com.movie.ratingservice.controller;

import com.movie.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @GetMapping("/{id}")
    public ResponseEntity<Float> getRating(@PathVariable("id") Integer movieId){
        return ResponseEntity.ok(ratingService.getRating(movieId));
    }
}
