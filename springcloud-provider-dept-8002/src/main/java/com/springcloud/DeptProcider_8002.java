package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    //服务器启动后，自动注册eureka中
@EnableDiscoveryClient  //服务
public class DeptProcider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProcider_8002.class,args);
    }
}
