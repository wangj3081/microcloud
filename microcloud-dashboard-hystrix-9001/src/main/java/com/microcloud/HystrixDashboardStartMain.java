package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * http://localhost:9001/hystrix
 * Hystrix 仪表盘
 * @Auther: wangjian
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardStartMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardStartMain.class, args);
    }
}
