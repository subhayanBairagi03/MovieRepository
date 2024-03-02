package com.movie.userservice.controller;

import com.movie.userservice.model.MovieCatalog;
import com.movie.userservice.service.UserCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class UserCatalogController {
    @Autowired
    private UserCatalogService userCatalogService;
    @GetMapping("/view")
    public ResponseEntity<Mono<List<MovieCatalog>>> getMovies(){
        return ResponseEntity.ok().body(userCatalogService.getMovieDetails().collectList());
    }
}
