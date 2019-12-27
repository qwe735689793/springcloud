package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixfindById") //失败后 调用的方法名
    public Dept findById(@PathVariable("id") Long id){
        Dept dept =deptService.findById(id);
        if(dept ==null){
            throw new RuntimeException("id=>"+id+"用户不存在");
        }
        return deptService.findById(id);
    }
    //备选方案@PathVariable("id")
    public Dept hystrixfindById(Long id) {
        Dept dept =new Dept();
        dept.setDeptno(id)
            .setDname("id=>"+id+"用户不存在")
            .setDb_source("no this database is Mysql");
        return dept;
    }

}
