package com.microcloud.controller;

import brave.Tracer;
import brave.Tracing;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: wangjian
 */
@Slf4j
@RestController
public class ConsulController {
    @Value(value = "${spring.application.name}")
    private String serverName;
    @Autowired
    private Tracer tracer;

    @GetMapping(value = "/echo")
    @HystrixCommand(fallbackMethod = "echoFallBackResult")
    public String echo(String message) {
        if (StringUtils.isBlank(message)) {
            log.error("「服务名称:"+serverName+",方法:echo」请求异常: 传入的参数为空");
            throw new NullPointerException("传入的参数为空");
        }
        long traceId = tracer.currentSpan().context().traceId();
        log.debug("traceId: " + traceId);
        log.debug("「"+serverName+"-》 echo」: result");
        return "Echo:" + message;
    }

    public String echoFallBackResult(String message) {
        return "服务异常";
    }

    /**
     * consul 检查服务方法
     * @return
     */
    @GetMapping(value = "/consul/info")
    public String info() {
        return "info";
    }

}
