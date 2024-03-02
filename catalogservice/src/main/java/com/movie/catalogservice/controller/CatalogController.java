package com.movie.catalogservice.controller;

import com.movie.catalogservice.model.MovieCatalog;
import com.movie.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @GetMapping("/catalog")
    private ResponseEntity<Flux<MovieCatalog>>getMovies(){
        return ResponseEntity.ok(catalogService.getMovies());
    }
}
