package com.crypto.exchange.server.repository;

import com.crypto.exchange.server.models.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAllByName(String name);
    User findByName(String name);

}
