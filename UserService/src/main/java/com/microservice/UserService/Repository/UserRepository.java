package com.microservice.UserService.Repository;

import com.microservice.UserService.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
