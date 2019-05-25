package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Auther: wangjian
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayMainStart {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMainStart.class, args);
    }
}
