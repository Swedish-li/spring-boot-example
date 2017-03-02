package com.lrs.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lrs.springboot.model.Student;

public interface StudentPageRepository extends PagingAndSortingRepository<Student, Integer> {
	
	Page<Student> findByAge(int age, Pageable pageable);
}
