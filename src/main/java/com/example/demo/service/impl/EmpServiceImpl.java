package com.example.demo.service.impl;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.pojo.Emp;
import com.example.demo.pojo.PageBean;
import com.example.demo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;

	//	@Override
	//	public PageBean page(Integer page, Integer pageSize) {
	//		
	//		Long count = empMapper.count();
	//		
	//		Integer start = (page -1)* pageSize;
	//		
	//		List<Emp> empList = empMapper.page(start, pageSize);
	//		
	//		PageBean pageBean = new PageBean(count,empList);
	//		return pageBean;
	//	}

//	public PageBean page(Integer page, Integer pageSize, String name, Short gender,
//			LocalDate begin, LocalDate end) {
//
//		PageHelper.startPage(page, pageSize);
//
//		List<Emp> empList = empMapper.list(name, gender, begin, end);
//
//		Page<Emp> p = (Page<Emp>) empList;
//
//		PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
//		return pageBean;
//	}

	
	   /*@Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long count = empMapper.count();

        //2. 获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }*/


    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        @SuppressWarnings("resource")
		Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
    
	@Override
	public void delete(List<Integer> ids) {
		empMapper.delete(ids);

	}

	@Override
	public void save(Emp emp) {
		//补全数据
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now()); //调用添加方法
		empMapper.insert(emp);

	}

//	  @Override
//	    public PageBean page(Integer page, Integer pageSize) {
//	        //1. 设置分页参数
//	        PageHelper.startPage(page,pageSize);
//
//	        //2. 执行查询
//	        List<Emp> empList = empMapper.list(name, gender, begin, end);
//	        @SuppressWarnings("resource")
//			Page<Emp> p = (Page<Emp>) empList;
//
//	        //3. 封装PageBean对象
//	        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
//	        return pageBean;
//	    }

	@Override
	public Emp getByid(Integer id) {
		
		return empMapper.getByid(id);
	}

	@Override
	public void upDate(Emp emp) {
		emp.setUpdateTime(LocalDateTime.now());
		empMapper.upDate(emp);
	}

    @Override
    public Emp login(Emp emp) {

		Emp e = empMapper.getByUseridAndPassword(emp);
		return e;
    }


}
