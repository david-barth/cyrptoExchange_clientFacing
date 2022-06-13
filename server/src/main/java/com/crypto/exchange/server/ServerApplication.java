package com.crypto.exchange.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServerApplication {
    public static void main(String[] args) {

        //TODO: Session with Corrado => Inspect design with analytics importer and consider a good approach to implementing cron job.  

        SpringApplication.run(ServerApplication.class, args);
    }
}