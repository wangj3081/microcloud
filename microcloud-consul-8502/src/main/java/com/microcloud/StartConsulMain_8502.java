package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @Auther: wangjian
 */
@SpringBootApplication
@EnableCircuitBreaker
public class StartConsulMain_8502 {

    public static void main(String[] args) {
        SpringApplication.run(StartConsulMain_8502.class, args);
    }
}
