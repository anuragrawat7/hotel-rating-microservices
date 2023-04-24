package com.microservice.UserService.Controller;

import com.microservice.UserService.Entities.User;
import com.microservice.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

}
