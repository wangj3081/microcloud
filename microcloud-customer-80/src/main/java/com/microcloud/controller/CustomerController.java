package com.microcloud.controller;

import com.microcloud.feignservice.IConsulService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @Auther: wangjian
 */
@RestController
@RequestMapping(value = "/customer")
@Slf4j
public class CustomerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancerClient balancerClient;
    @Resource
    private IConsulService consulService;
    @Value(value = "${spring.application.name")
    private String serverName;

    @GetMapping(value = "/info")
    public String getInfo(String echo) {
       // String serviceName = "microcloud-consul";
        String serviceName = "microcloud-gateway";
        ServiceInstance choose = balancerClient.choose(serviceName);
        System.out.println("" + choose.getHost() + " : " + choose.getPort() + " : " + choose.getUri() + " : " + choose.getServiceId());
        URI chooseUri = choose.getUri();
        String result = "";
        if (chooseUri != null) {
            result = restTemplate.getForObject(chooseUri + "/echo?message=" + echo, String.class);
        }
//        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
//        if (!CollectionUtils.isEmpty(instances)) {
//            URI uri = instances.get(0).getUri();
//            result = restTemplate.getForObject(uri + "/echo?message=" + echo, String.class);
//            return result;
//        }
//        String result = consulService.echo(echo);
        return result;
    }

    @GetMapping(value = "/restInfo")
    public String feignInfo(String echo) {
        log.debug("「Constoer Controller "+serverName+"」start");
        String result = consulService.echo(echo);
        log.debug("「Constoer Controller "+serverName+"」end");
        return result;
    }
}
