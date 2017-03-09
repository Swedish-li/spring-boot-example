package com.lrs.springboot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lrs.springboot.model.ClassroomStuNumDto;
import com.lrs.springboot.model.Student;
import com.lrs.springboot.model.StudentBadDto;
import com.lrs.springboot.model.StudentGoodDto;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest
public class StudentPageRepositoryTest {
	@Autowired
	private StudentPageRepository repository;

	Logger logger = LoggerFactory.getLogger(StudentPageRepositoryTest.class);

	/**
	 * 分页查询
	 */
	@Test
	public void testFindByAge() {
		PageRequest pageRequest = new PageRequest(1, 3);
		Page<Student> page = repository.findByAge(12, pageRequest);
		assertEquals(2, page.getTotalPages());
		assertEquals(6, page.getTotalElements());
		assertEquals(1, page.getNumber());
	}

	@Test
	public void testFindAllSort() {
		List<Student> list = (List<Student>) repository.findAll(new Sort(Sort.Direction.ASC, "name"));
		System.out.println(list);
	}

	@Rollback
	@Test
	public void testSaveIterableOfS() {

		Student s1 = new Student("Jack1", "number 12", 15);
		Student s2 = new Student("Mike1", "number 23", 23);
		Student s3 = new Student("Tom1", "number 12", 20);
		Student s4 = new Student("Alice1", "number 12", 12);
		List<Student> list = Arrays.asList(s1, s2, s3, s4);
		Iterable<Student> it = repository.save(list);

		assertNotNull(it);
	}

	@Test
	public void testListStu() {
		List<StudentBadDto> list = repository.listBadStu();
		assertEquals(24, list.size());
		StudentBadDto studentBadDto = list.get(0);
		logger.info("studentBadDto:{}", studentBadDto);
		assertEquals(1, studentBadDto.getStu().getId());
		assertEquals(1, studentBadDto.getClz().getId());
	}

	@Test
	public void testListStuGoodDto() {
		List<StudentGoodDto> dtos = repository.listGoodStu();

		assertEquals(24, dtos.size());
		logger.info("good student dto:{}", dtos);
		StudentGoodDto dto = dtos.get(0);
		assertEquals(1, dto.getSid());
		assertEquals(1, dto.getClzId());
	}

	@Test
	public void testListClassrooms() {
		List<ClassroomStuNumDto> classStuNumDtoS = repository.listClassrooms();
		assertEquals(1, classStuNumDtoS.size());
		logger.info("classStuNumDtos:{}", classStuNumDtoS);
		assertEquals(1, classStuNumDtoS.get(0).getCid());
		assertEquals(24, classStuNumDtoS.get(0).getSnum());
	}

	/**
	 * 必须映射Student的所有属性(不包括cid）
	 */
	@Test
	public void testListStuByNativeSQL() {
		List<Student> list = repository.ListStuByNativeQuery();
		assertEquals(24, list.size());
		assertEquals(1, list.get(0).getId());
		logger.info("student list:{}", list);
	}
	/**
	 * 查询结果中的列名不可相同
	 */
	@Test
	public void testNativeSQL() {
		List<Object[]> list = repository.listByNativeQuery();
		assertEquals(24, list.size());
		assertEquals(1, list.get(0)[0]);
		logger.info("studentGoodDtos：{}", Arrays.toString(list.get(0)));
	}
}
