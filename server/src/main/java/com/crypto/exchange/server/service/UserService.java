package com.crypto.exchange.server.service;


import com.crypto.exchange.server.entity.User;
import com.crypto.exchange.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

}
