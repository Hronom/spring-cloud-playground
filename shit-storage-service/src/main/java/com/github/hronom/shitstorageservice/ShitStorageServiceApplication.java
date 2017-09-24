package com.github.hronom.shitstorageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShitStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShitStorageServiceApplication.class, args);
    }
}
