package com.example.bootstrap2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.bootstrap2")
@EntityScan("com.example.bootstrap2")
@SpringBootApplication
public class Bootstrap2Application {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap2Application.class, args);
    }

}
