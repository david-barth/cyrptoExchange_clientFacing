package com.crypto.exchange.server.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "mySqlDataSource")
    public DataSource mySqlDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/initialDB");
        dataSourceBuilder.username("dzb10035");
        dataSourceBuilder.password("IloveRomeo!30");
        return dataSourceBuilder.build();
    }
}
