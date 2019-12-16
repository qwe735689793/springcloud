package com.springcloud.mapper;

import com.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DeptMapper {
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAllDept();
}
