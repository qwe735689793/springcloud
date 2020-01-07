package com.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//
@SpringBootApplication
@EnableEurekaClient    //服务器启动后，自动注册到 eureka中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker
public class DeptProcider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProcider_8001.class,args);
    }
    //增加一个servlet
}
