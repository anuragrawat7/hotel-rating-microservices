package com.microservice.HotelService.service.impl;

import com.microservice.HotelService.entities.Hotel;
import com.microservice.HotelService.exception.ResourceNotFoundException;
import com.microservice.HotelService.repository.HotelRepository;
import com.microservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(int id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel given id not found"));
    }
}
