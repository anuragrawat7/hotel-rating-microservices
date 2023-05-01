package com.microservices.RatingService.Repository;

import com.microservices.RatingService.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, Integer> {

    //custom finders
    List<Rating> findByUserId(int id);

    List<Rating> findByHotelId(int id);
}
