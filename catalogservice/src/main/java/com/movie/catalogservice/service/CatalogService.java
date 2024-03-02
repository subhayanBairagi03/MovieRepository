package com.movie.catalogservice.service;

import com.movie.catalogservice.model.MovieCatalog;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class CatalogService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public Flux<MovieCatalog> getMovies(){
        //Db call
        var mapOfMovies= Map.of(1,"Inception",
                2,"Baba Keno Chakor",
                3,"Oppenheimer",
                4,"Beder Meye Jyotsna");
        return  Flux.fromIterable(mapOfMovies.keySet())
                .flatMap(movieId -> Mono.zip(getBookCount(movieId),getRating(movieId),(c,d)->new MovieCatalog(mapOfMovies.get(movieId),c,d)));

    }
@SneakyThrows
    private Mono<Float> getRating(Integer movieId) {
        return webClientBuilder.baseUrl("http://rating-service/rate/"+movieId)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Float.class);
    }
@SneakyThrows
    private Mono<Long> getBookCount(Integer movieId) {
        return webClientBuilder.baseUrl("http://booking-service/book/viewcount/"+movieId)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Long.class);
    }
}
