package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.PageBean;

/**
 * 员工管理
 */

@Service
public interface EmpService {

//	PageBean page(Integer page, Integer pageSize,String name,Short gender, 
//		LocalDate begin,LocalDate end);
	
	 PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end);
	
	void delete (List<Integer> ids);

	void save(Emp emp);

	Emp getByid(Integer id);

	void upDate(Emp emp);


    Emp login(Emp emp);
}
