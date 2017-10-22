package com.lrs.boot.swagger2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lrs.boot.swagger2.dto.Person;

@Service
public class PersonService {

	public List<Person> getAll() {
		List<Person> list = new ArrayList<>();

		Person zhang = new Person();
		zhang.firstName = "张";
		zhang.lastName = "强";
		zhang.username = "张强";

		Person zhao = new Person();

		zhao.firstName = "赵";
		zhao.lastName = "丰";
		zhao.username = "赵丰";

		list.add(zhang);
		list.add(zhao);

		return list;

	}
}
