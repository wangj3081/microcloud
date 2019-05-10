package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @Auther: wangjian
 */
@SpringBootApplication
@EnableCircuitBreaker // 启用熔断处理配置
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
