package com.github.hronom.shitstorageservice;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceConfig {

    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
}
