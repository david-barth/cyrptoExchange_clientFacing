package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.models.old.common.entity.User;
import com.crypto.exchange.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{name}")
    User getUserByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/getUsers/{name}")
    List<User> getUsersByName(@PathVariable String name) {
        return userService.findAllByName(name);
    }

    @RequestMapping("/hello")
    List<User> sayHello() {
        return userService.findAllByName("David");
    }

}
