package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * http://localhost:9001/hystrix
 * Hystrix 仪表盘
 * @Auther: wangjian
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardStartMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardStartMain.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HystrixDashboardStartMain.class); // 打成 war 包后执行
    }
}
