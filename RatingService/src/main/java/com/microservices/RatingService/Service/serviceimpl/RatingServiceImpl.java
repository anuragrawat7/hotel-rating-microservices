package com.microservices.RatingService.Service.serviceimpl;

import com.microservices.RatingService.Entities.Rating;
import com.microservices.RatingService.Repository.RatingRepository;
import com.microservices.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUserId(int id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getbyHotelId(int id) {
        return ratingRepository.findByHotelId(id);
    }
}
