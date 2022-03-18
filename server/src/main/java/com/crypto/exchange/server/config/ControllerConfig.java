package com.crypto.exchange.server.config;

import com.crypto.exchange.server.repository.UserRepository;
import com.crypto.exchange.server.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
