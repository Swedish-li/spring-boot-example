package com.lrs.boot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lrs.boot.mybatis.model.Employee;

/**
 * 
 * @author Swedish-li
 *
 */
@Mapper
public interface EmployeeMapper {

	@Select("SELECT id,name,state,city FROM employee WHERE name=#{name}")
	Employee selectByName(@Param("name") String name);

	Employee selectById(@Param("id") int id);

}
