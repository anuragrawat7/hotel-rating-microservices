package com.microservice.HotelService.service;

import com.microservice.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(int id);
}
