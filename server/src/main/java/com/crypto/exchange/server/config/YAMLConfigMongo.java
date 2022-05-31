package com.crypto.exchange.server.config;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("mongo")
@Getter
public class YAMLConfigMongo {
    private String url;
    private String DBname;
}
