package com.microservice.UserService.Service.Impl;

import com.microservice.UserService.Entities.User;
import com.microservice.UserService.Exception.ResourceNotFoundException;
import com.microservice.UserService.Repository.UserRepository;
import com.microservice.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
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
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
