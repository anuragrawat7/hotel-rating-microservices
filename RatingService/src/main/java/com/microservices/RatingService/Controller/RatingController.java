package com.microservices.RatingService.Controller;

import com.microservices.RatingService.Entities.Rating;
import com.microservices.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAll());
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getHotelsById(@PathVariable int hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getbyHotelId(hotelId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getUsersById(@PathVariable int userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getByUserId(userId));
    }


}
