package com.example.demo.service;

import com.example.demo.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
	
	List<Dept> list();
	
	void delete(Integer id) throws Exception;


	void add(Dept dept);
}
