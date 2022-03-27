package com.crypto.exchange.server.service;


import com.crypto.exchange.server.entity.User;
import com.crypto.exchange.server.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
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
