package com.williammiranda.workshop.mongodb.services;

import com.williammiranda.workshop.mongodb.domain.User;
import com.williammiranda.workshop.mongodb.gateway.database.repository.UserRepository;
import com.williammiranda.workshop.mongodb.services.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){ return userRepository.findAll(); };
}
