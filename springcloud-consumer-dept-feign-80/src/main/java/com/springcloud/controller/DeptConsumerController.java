package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptClienSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "test")
public class DeptConsumerController {
    //参数(url,实体:map类型  即要传递的参数,class<T> responseType:  响应结果的类型)
    @Autowired
    private RestTemplate restTemplate;      //提供多种便捷访问的http服务的方法， 简单的Rest服务模板
    //http://localhost:8001/api/findAllDept
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //配置服务地址，实现负载均衡
    private static final String REST_URL_PREFIX = "http://SPRINGCLOU-PROVIDER-DEPT";

    @Autowired
    private DeptClienSerice deptClienSerice;
//    @RequestMapping("/Consumer/dept/add")
//    public boolean add(Dept dept){
//        return restTemplate.postForObject(REST_URL_PREFIX+"/api/addDept/",dept,Boolean.class);
//    }
//
    @RequestMapping("/Consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClienSerice.findById(id);
    }

    @RequestMapping("/Consumer/dept/findAllDept")
    public List<Dept> findAllDept(){
        return this.deptClienSerice.findAllDept();
    }

    @RequestMapping("/test")
    public String findAllDept1(){
        return "1";
    }
}
