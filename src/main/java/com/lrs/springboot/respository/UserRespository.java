package com.lrs.springboot.respository;

import org.springframework.data.repository.CrudRepository;

import com.lrs.springboot.model.User;

public interface UserRespository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
