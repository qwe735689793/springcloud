package com.springcloud.service;

import com.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
//熔断降级
@Component
public class DeptClienSericeFallbackFactory implements FallbackFactory {
    @Override
    public DeptClienSerice create(Throwable throwable) {     //返回feign接口对应的对象，所以定义为object

        return new DeptClienSerice() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
                Dept dept =new Dept();
                dept.setDeptno(id)
                        .setDname("id=>"+id+"用户不存在，该服务已被降级关闭 ")
                        .setDb_source("no this database is Mysql");
                return dept;
            }

            @Override
            public List<Dept> findAllDept() {
                return null;
            }
        };
    }
}
