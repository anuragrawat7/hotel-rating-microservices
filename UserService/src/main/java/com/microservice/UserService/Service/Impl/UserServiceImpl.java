package com.microservice.UserService.Service.Impl;

import com.microservice.UserService.Entities.Ratings;
import com.microservice.UserService.Entities.User;
import com.microservice.UserService.Exception.ResourceNotFoundException;
import com.microservice.UserService.Repository.UserRepository;
import com.microservice.UserService.Service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        ArrayList<Ratings> ratingList = restTemplate.getForObject("http://localhost:8083/ratings/users/"+ user.getUserId(),ArrayList.class);

        return user;
    }
}
