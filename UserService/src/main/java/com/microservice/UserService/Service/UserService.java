package com.microservice.UserService.Service;

import com.microservice.UserService.Entities.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAllUsers();

    User getUser(Integer id);
}
