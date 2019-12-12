package com.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor //无参构造函数
@Accessors(chain = true) //链式写法
public class Dept implements Serializable { //所有实体类务必实现序列化

    private Long deptno;
    private String dname;
    private String db_source;

    public Dept (String dname){
        this.dname = dname;
    }
}
