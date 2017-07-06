package com.lrs.springboot.common;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisConfigTest {
	// the template is thread-safe and can be reused across multiple instances.
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> template;

	@Resource(name = "stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;

	// inject the template as ListOperations
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valOp;

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Test
	public void testOps() {
		String keyVal = "key-ops";
		valOp.set(keyVal, "ops_value");
		String val = valOp.get(keyVal);

		assertThat(val, equalTo("ops_value"));

		String listKey = "list-key";
		listOps.leftPush(listKey, "list-val1");
		String listVal = listOps.leftPop(listKey);
		assertThat(listVal, equalTo("list-val1"));
	}

	@Test
	public void testRedisTemplate() {
		String keyForVal = "keyForVal";
		template.opsForValue().set(keyForVal, "opsForValue");
		assertThat(template.opsForValue().get(keyForVal), equalTo("opsForValue"));
	}

	@Test
	public void testUseCallback() {
		String val = stringRedisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				String keyDoInRedis = "RedisCallback";
				long dbSzie = connection.dbSize();
				System.out.println("dbsize=" + dbSzie);
				StringRedisConnection conn = ((StringRedisConnection) connection);
				conn.set(keyDoInRedis, "doInRedis");
				return conn.get(keyDoInRedis);
			}
		});
		
		assertThat(val, equalTo("doInRedis"));
	}
}
