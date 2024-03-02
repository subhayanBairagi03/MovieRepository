package com.movie.bookingservice.controller;

import com.movie.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/viewcount/{id}")
    public ResponseEntity<Long> getViewCount(@PathVariable("id")Integer movieId){
        return ResponseEntity.ok(bookingService.getViewCount(movieId));
    }
}
