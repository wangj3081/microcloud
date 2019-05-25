package com.microcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wangjian
 */
@RestController
public class ConsulController {

    @GetMapping(value = "/echo")
    @HystrixCommand(fallbackMethod = "echoFallback")
    public String echo(String message) {
        if (StringUtils.isBlank(message)) {
            throw new NullPointerException("传入的参数不能为空");
        }
        return "Echo-222:" + message;
    }

    public  String  echoFallback(String message) {
        return "consul-8502: 服务异常";
    }

    /**
     * consul 检查服务方法
     * @return
     */
    @GetMapping(value = "/info")
    public String info() {
        return "info2222";
    }
}
