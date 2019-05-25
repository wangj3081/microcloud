package com.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Created by wangjian on 2019/5/25.
 */
@SpringBootApplication
@EnableZipkinServer //zipkin server
public class Zipkin_8601_StartMain {

    public static void main(String[] args) {
        SpringApplication.run(Zipkin_8601_StartMain.class, args);
//        HttpEncodingAutoConfiguration
    }
}
