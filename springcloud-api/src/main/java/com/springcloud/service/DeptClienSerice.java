package com.springcloud.service;

import com.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "SPRINGCLOU-PROVIDER-DEPT",fallbackFactory=DeptClienSericeFallbackFactory.class)
@Component
public interface DeptClienSerice {
    @RequestMapping("/api/Consumer/dept/add")
    public boolean addDept(Dept dept);
    @RequestMapping("/api/findById/{id}")
    public Dept findById(@PathVariable("id" )Long id);
    @RequestMapping("/api/findAllDept")
    public List<Dept> findAllDept();
}
