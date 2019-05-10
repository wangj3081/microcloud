package com.microcloud.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义 actuator 监控 health
 * @Auther: wangjian
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Health health = Health.up().withDetail("info", "服务健在").build();
//                .down().withDetail("info", "服务西去").build();
        return health;
    }
}
