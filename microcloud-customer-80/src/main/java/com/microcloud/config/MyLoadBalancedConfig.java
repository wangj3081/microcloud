package com.microcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: wangjian
 */
@Configuration
public class MyLoadBalancedConfig {

    // 自定义负载均衡策略
    @Bean
    public IRule ribbonRule() {
     return  new com.netflix.loadbalancer.RandomRule();
    }


}
