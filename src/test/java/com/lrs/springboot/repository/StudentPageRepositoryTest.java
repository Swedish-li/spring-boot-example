package com.lrs.springboot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lrs.springboot.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest
public class StudentPageRepositoryTest {
	@Autowired
	private StudentPageRepository repository;
	/**
	 * 分页查询
	 */
	@Test
	public void testFindByAge() {
		PageRequest pageRequest = new PageRequest(1, 3);
		Page<Student> page = repository.findByAge(12, pageRequest);
		assertEquals(2, page.getTotalPages());
		assertEquals(4, page.getTotalElements());
		assertEquals(1, page.getNumber());
	}

	@Test
	public void testFindAllSort() {
		List<Student> list = (List<Student>) repository.findAll(new Sort(Sort.Direction.ASC,"name"));
		System.out.println(list);
	}


	@Commit
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

}
