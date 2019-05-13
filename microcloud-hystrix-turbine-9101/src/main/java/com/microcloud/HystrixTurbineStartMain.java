package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Auther: wangjian
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineStartMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineStartMain.class, args);
    }
}
