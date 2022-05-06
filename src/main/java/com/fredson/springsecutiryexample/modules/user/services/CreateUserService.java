package com.fredson.springsecutiryexample.modules.user.services;

import com.fredson.springsecutiryexample.modules.user.entities.User;
import com.fredson.springsecutiryexample.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;

    public User execute(User user) {
        User existsUser = userRepository.findByUsername(user.getUsername());
        if (existsUser != null) throw new Error("User already exists");
        return userRepository.save(user);
    }
}
