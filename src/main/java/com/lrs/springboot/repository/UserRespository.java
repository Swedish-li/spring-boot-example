package com.lrs.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lrs.springboot.model.User;

/**
 * Spring jpa data 的接口 Repository<User,Long> ，空接口，标志这个数据访问类由Spring
 * data管理的标志接口，泛型代表实体，主键
 * 
 * @author Swedish-li
 *
 */
public interface UserRespository extends CrudRepository<User, Long> {
	User findByEmail(String email);

	// 使用Hql查询
	@Query("select u from User u where u.id=?1")
	User loadById(Long id);

	// Spring jpa data 自动实现的查询
	User readById(Long id);

	List<User> getById(Long id);

	User findById(Long id);

	List<User> findByEmailAndName(String email, String name);
}
