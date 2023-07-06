package com.example.demo.mapper;

import com.example.demo.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
	
//	@Select("select count(*) from emp")
//	public Long count();
//	
//	@Select("select * from emp limit #{start},#{pageSize}")
//	public List<Emp> page(Integer start, Integer pageSize);
	

	
//    @Select("select * from emp")
    public List<Emp> list (String name, Short gender, LocalDate begin, LocalDate end);

	public void delete(List<Integer> ids);


	 @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
			             "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
	public void insert(Emp emp);

//	 @Select("select * from emp where  id = #{id}")

	@Select("select * from emp where  id = #{id}")
	 Emp getByid(Integer id);


	public void upDate(Emp emp);

    @Select("select * from emp where username =#{username} and password = #{password}")
    Emp getByUseridAndPassword(Emp emp);

	@Delete("delete from emp where dept_id = #{deptId} ")
	public int deleteByDeptId(Integer dptId);
}
