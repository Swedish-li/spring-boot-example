package com.lrs.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lrs.springboot.model.Student;
import com.lrs.springboot.model.StudentBadDto;
import com.lrs.springboot.model.StudentGoodDto;

public interface StudentPageRepository extends PagingAndSortingRepository<Student, Integer> {

	Page<Student> findByAge(int age, Pageable pageable);

	/**
	 * 使用多条Sql来查询，不建议使用
	 * 
	 * @return
	 */
	@Query("select new com.lrs.springboot.model.StudentBadDto(stu,cla) from Student stu,Classroom cla where stu.cid=cla.id")
	List<StudentBadDto> listBadStu();

	/**
	 * dto中不使用对象，把属性分开处理
	 * 
	 * @return
	 */
	@Query("select new com.lrs.springboot.model.StudentGoodDto(stu.id,stu.name,cla.id,cla.name,cla.grade) from Student stu,Classroom cla where stu.cid=cla.id")
	List<StudentGoodDto> listGoodStu();
}
