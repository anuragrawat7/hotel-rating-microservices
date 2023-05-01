package com.microservices.RatingService.Service;

import com.microservices.RatingService.Entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAll();

    List<Rating> getByUserId(int id);

    List<Rating> getbyHotelId(int id);
}
