package com.lrs.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.hamcrest.Matchers.*;

/**
 * 控制层单元测试
 * 
 * @author Swedish-li
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class EchartsExampleControllerTest {

	private final static String BASE_URL = "/echarts/";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	private String url(String url) {
		return BASE_URL + url;
	}

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testGetUser() throws Exception {
		mockMvc.perform(get(url("user")).param("birth", "1989-12-15 18:18:15"))
				.andDo(log())
				.andExpect(status().isOk())
				.andExpect(jsonPath("birth", is("1989-12-15 18:18:15")));
	}

	@Test
	public void testBar1() throws Exception {
		mockMvc.perform(get(url("bar1")))
				.andDo(log())
				.andExpect(status().isOk());
	}

	@Test
	public void testGetFunnel() throws Exception {
		mockMvc.perform(get(url("funnel")))
				.andDo(log())
				.andExpect(status().isOk());
	}

}
