package com.microcloud.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Auther: wangjian
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/info")
    public String getInfo(String echo) {
        String serviceName = "microcloud-consul-8501";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        if (!CollectionUtils.isEmpty(instances)) {
            URI uri = instances.get(0).getUri();
            String result = restTemplate.getForObject(uri + "/echo?message=" + echo, String.class);
            return result;
        }
        return "";
    }
}
