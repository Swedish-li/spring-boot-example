package com.lrs.springboot.respository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lrs.springboot.App;
import com.lrs.springboot.model.User;
import com.lrs.springboot.repository.UserRespository;
/**
 * 所有单元测试通过
 * @author Swedish-li
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = App.class)
public class UserRespositoryTest {
	private final static Logger logger = LoggerFactory.getLogger(UserRespositoryTest.class);
	@Resource
	private UserRespository userRespository;

	@Test
	public void testFindByEmail() {
		User user = userRespository.findByEmail("test001@gmail.com");
		logger.info("user:{}", user);
		assertNotNull(user);
		assertEquals(2, user.getId());
		assertEquals("Swedish-li", user.getName());
		assertEquals("test001@gmail.com", user.getEmail());
	}

	/**
	 * 没有 @Commit 注释，本次单元测试会自动回滚
	 */
	@Test
	// @Commit
	@Rollback
	public void testSaveS() {
		User user = new User();
		user.setName("Swedish-li");
		user.setEmail("test001@gmail.com");
		User user1 = userRespository.save(user);
		logger.info("user:{}", user1);
		assertNotNull(user1);
	}

	@Test
	public void testSaveIterableOfS() {
		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setEmail("1322@163.com");
		user1.setName("Tom");
		users.add(user1);
		User user2 = new User();
		user2.setEmail("test222@sohu.com");
		user2.setName("Mike");
		users.add(user2);
		Iterable<User> userIt = userRespository.save(users);
		for (User u : userIt) {
			logger.info("user:{}", u);
		}
		assertNotNull(userIt);
		assertTrue(userIt instanceof List);

	}

	@Test
	public void testFindOne() {
		User user = userRespository.findOne(2L);
		assertNotNull(user);
		assertEquals(2L, user.getId());

	}

	@Test
	public void testExists() {
		boolean isExisted = userRespository.exists(2L);
		assertTrue(isExisted);
	}

	@Test
	public void testFindAll() {
		Iterable<User> users = userRespository.findAll();
		assertNotNull(users);
		User user = users.iterator().next();
		assertEquals(2L, user.getId());
	}

	@Test
	public void testFindAllIterableOfID() {
		Iterable<User> users = userRespository.findAll(Arrays.asList(2L));
		assertNotNull(users);
		User user = users.iterator().next();
		assertEquals(2L, user.getId());
	}

	@Test
	public void testCount() {
		long count = userRespository.count();
		assertEquals(1L, count);
	}

	@Test
	@Rollback
	public void testDeleteID() {
		userRespository.delete(2L);
		assertEquals(0L, userRespository.count());
	}

	@Test
	@Rollback
	public void testDeleteT() {
		User user = new User(2L);
		userRespository.delete(user);
		assertEquals(0L,userRespository.count());
		
	}

	@Test
	@Rollback
	public void testDeleteIterableOfQextendsT() {
		userRespository.delete(Arrays.asList(new User(2L)));
		assertEquals(0L,userRespository.count());
	}

	@Test
	@Rollback
	public void testDeleteAll() {
		userRespository.deleteAll();
		assertEquals(0L,userRespository.count());
	}
	@Test
	public void testLoadById(){
		User user = userRespository.loadById(2L);
		logger.info("user:{}",user);
		assertNotNull(user);
	}
	@Test
	public void testGetById() {
		List<User> users = userRespository.getById(2L);
		assertNotNull(users);
		assertTrue(users instanceof ArrayList);
		
	}
}
