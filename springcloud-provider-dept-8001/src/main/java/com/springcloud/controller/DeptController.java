package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeptController {
    @Autowired
    private DeptService deptService;
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
}
