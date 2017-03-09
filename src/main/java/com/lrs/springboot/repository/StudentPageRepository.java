package com.lrs.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lrs.springboot.model.ClassroomStuNumDto;
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
	@Query("select new com.lrs.springboot.model.StudentBadDto(stu,cla) "
			+ "from Student stu,Classroom cla where stu.cid=cla.id")
	List<StudentBadDto> listBadStu();

	/**
	 * dto中不使用对象，把属性分开处理
	 * 
	 * @return
	 */
	@Query("select new com.lrs.springboot.model.StudentGoodDto(stu.id,stu.name,cla.id,cla.name,cla.grade) "
			+ "from Student stu,Classroom cla where stu.cid=cla.id")
	List<StudentGoodDto> listGoodStu();

	/**
	 * 查询班级信息同时获取班级学生人数 使用HQL在没有对象关联的情况下是无法使用left join的，这在做group时无法统计得出学生为0的班级
	 * 
	 * @return
	 */
	// 构造班级信息
	@Query("select new com.lrs.springboot.model.ClassroomStuNumDto(cla.id,cla.name,cla.grade,count(stu.id))"
			+ " from Student stu,Classroom cla where stu.cid=cla.id group by cla.id")
	List<ClassroomStuNumDto> listClassrooms();

	/**
	 * 使用原生SQL进行查询
	 * 
	 * @return
	 */
	@Query(nativeQuery = true, value = "select stu.id,stu.address,stu.age,stu.name,stu.cid from t_student stu")
	List<Student> ListStuByNativeQuery();

	/**
	 * 查询结果为List<Object[]>
	 * 
	 * @return
	 */
	@Query(nativeQuery = true, value = "select  stu.id as sid,cla.id as cid,stu.name,stu.age,cla.grade,cla.name as cname"
			+ " from t_student stu left join t_classroom cla on stu.cid=cla.id")
	List<Object[]> listByNativeQuery();
}
