package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class configBean {
    //构造ResmTemplate
    //@LoadBalanced 实现负载均衡
    //常见的几种负载均衡的算法，使用的时候  把new RandomRule改为方法
    // RoundRobinRule : 轮询
    // RandomRule： 随机
    //AvailabilityFiteringRule：先过滤掉 跳闸（崩溃） 访问故障的服务，在进行轮询
    //RetryRule: 先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行，重试

    @Bean
    @LoadBalanced       //ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
