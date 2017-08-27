package com.lrs.boot.mybatis.mapper;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.lrs.boot.mybatis.model.Employee;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

	@Autowired
	EmployeeMapper mapper;

	@Test
	public void testSelectByName() {
		Employee employee = mapper.selectByName("周九");
		
		assertThat(employee.city, equalTo("南京"));
		assertThat(employee.name, equalTo("周九"));
		assertThat(employee.state, equalTo("1"));

	}

}
