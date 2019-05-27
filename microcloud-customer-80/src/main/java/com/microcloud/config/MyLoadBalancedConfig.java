package com.microcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: wangjian
 */
//@Configuration // 自定义的 ribbon 负载均衡策略在与 gateway 的整合中总出现异常，目前未深究，采取默认的负载处理
public class MyLoadBalancedConfig {

    // 自定义负载均衡策略
//    @Bean
    public IRule ribbonRule() {
     return  new com.netflix.loadbalancer.RandomRule();
    }


}
