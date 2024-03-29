package com.movie.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RatingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingserviceApplication.class, args);
	}

}
