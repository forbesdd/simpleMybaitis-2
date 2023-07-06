package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.PageBean;
import com.example.demo.pojo.Result;
import com.example.demo.service.EmpService;

import lombok.extern.slf4j.Slf4j;

/**
 * 従業員管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")

public class EmpController {

	@Autowired
	private EmpService empService;


	//条件分页查询

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
	
	@DeleteMapping("/{ids}")
	public Result delete(@PathVariable List<Integer> ids) {
		log.info("削除選択:{}", ids);
		empService.delete(ids);
		return Result.success();
	}

	//新 增
	@PostMapping
	public Result save(@RequestBody Emp emp) {
		//记录日志
		log.info("新增员工, emp:{}", emp); //调用业务层新增功能 
		empService.save(emp);
		//响 应
		return Result.success();
	}
	@GetMapping("/{id}")
	public Result getByid(@PathVariable Integer id ) {
		
		log.info("Idによる調べ:{}",id);
		Emp emp = empService.getByid(id);
		return Result.success(emp);
		
	}
	
	@PutMapping
	public Result upDate(@RequestBody Emp emp) {
		log.info("従業員情報修正{}",emp);
		empService.upDate(emp);
		return Result.success();
	}
	

}
