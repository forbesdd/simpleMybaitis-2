package com.example.demo.mapper;

import com.example.demo.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into dept_log(create_time,description) values(#{createTime},#{description})")
    public void insert(DeptLog log);
}
