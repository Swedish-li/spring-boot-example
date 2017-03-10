package com.lrs.springboot.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring Boot 属性配置和使用
 * 文章链接：http://blog.csdn.net/isea533/article/details/50281151
 * 
 * Spring
 * boot参数配置文档：http://docs.spring.io/spring-boot/docs/1.2.3.RELEASE/reference/html/common-application-properties.html
 * 
 * @author Swedish-li
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@SpringBootTest
public class TestSpringbootProperties {
	Logger log = LoggerFactory.getLogger(TestSpringbootProperties.class);

	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Test
	public void testValue() {
		assertEquals("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", jdbcUrl);
	}

}
