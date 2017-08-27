package com.lrs.boot.mybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lrs.boot.mybatis.mapper.EmployeeMapper;

@SpringBootApplication
public class App implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	private final EmployeeMapper employeeMapper;

	public App(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(this.employeeMapper.selectByName("王三"));
	}

}
