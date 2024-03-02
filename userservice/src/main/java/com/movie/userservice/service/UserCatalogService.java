package com.movie.userservice.service;

import com.movie.userservice.model.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UserCatalogService {
    @Autowired
    private WebClient.Builder webClientBuilder;
    public Flux<MovieCatalog> getMovieDetails(){
        return webClientBuilder.baseUrl("http://catalog-service/catalog").build().get()
                .retrieve()
                .bodyToFlux(MovieCatalog.class);
    }
}
