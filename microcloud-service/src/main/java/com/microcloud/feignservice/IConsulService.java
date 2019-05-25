package com.microcloud.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 添加 feign 接口
 * @Auther: wangjian
 */
//@FeignClient(value = "microcloud-consul") // value 中的内容为注册在consul中的服务名
@FeignClient(value = "microcloud-gateway") // value 中的内容为注册在consul中的服务名
public interface IConsulService {

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    String echo(@RequestParam(value = "message") String message);
}
