package com.github.hronom.shitstorageclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableCircuitBreaker
@EnableHystrix
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ShitStorageClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShitStorageClientApplication.class, args);
    }
}
