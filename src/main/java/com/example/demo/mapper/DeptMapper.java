package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Dept;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
	
	@Select("select * from dept")
	List<Dept>list();

	@Delete("delete from dept where id = #{id}")
	void deleteById(Integer id);

	@Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
	void insert(Dept dept);
}
