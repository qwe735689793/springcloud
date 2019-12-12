package com.springcloud.service.impl;

import com.springcloud.mapper.DeptMapper;
import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAllDept();
    }
}
