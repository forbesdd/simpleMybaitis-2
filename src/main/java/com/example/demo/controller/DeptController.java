package com.example.demo.controller;

import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Result;
import com.example.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
	
//	private static Logger log = LoggerFactory.getLogger(DeptController.class);
	
//	@RequestMapping("Value = "/depts" ,method = RequestMethod.GET)	

	   @Autowired
		private DeptService deptService; 
	
	@GetMapping
	public Result list() {
		log.info("全部の部門");
	
		
	  List<Dept>  deptList =	deptService.list();
	  
		return Result.success(deptList);
		
	}
	@DeleteMapping("/{id}")
	public Result delete (@PathVariable Integer id) throws Exception {
		log.info("IDによる削除{}",id);
		deptService.delete(id);
		return Result.success();
	}
	@PostMapping
	public Result add (@RequestBody Dept dept) {
		log.info("部門名追加{}",dept);
		deptService.add(dept);
		return Result.success();
	}
}
