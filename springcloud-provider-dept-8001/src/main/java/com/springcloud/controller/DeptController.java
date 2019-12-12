package com.springcloud.controller;

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

    @Autowired
    private DiscoveryClient client;
    @PostMapping("/addDept")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/findById/{id}")
    public Dept findById(@PathVariable("id") Long id){
        return deptService.findById(id);
    }
    @RequestMapping("/findAllDept")
    public List<Dept> findAllDept(){
        return deptService.findAllDept();
    }

    //用于公司中给其他人看该微服务的作用
    @GetMapping("/dpet/discovery")
    public Object discovery(){
        //获取微服务清单，即eureka中的列表
        List<String> services = client.getServices();
        System.out.println("discovery=>service"+services);
        //通过eureka中的微服务id ，取得一个微服务的信息+

        List<ServiceInstance> instances = client.getInstances("SPRINGCLOU-PROVIDER-DEPT");
        for(ServiceInstance instance:instances){
            System.out.println(
                    instance.getHost()+" "+
                    instance.getPort()+" "+
                    instance.getUri()+" "+
                    instance.getServiceId()
                    );
        }
        return this.client;

    }
}
