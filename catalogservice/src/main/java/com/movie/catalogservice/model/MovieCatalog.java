package com.movie.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCatalog {
    private String movieName;
    private Long bookCount;
    private Float rating;
}
