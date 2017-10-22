package com.lrs.boot.mybatis;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@ClassRule
	public static OutputCapture out = new OutputCapture();

	@Test
	public void test() {
		String output = out.toString();
		assertThat(output).contains("name=王三, state=0, city=上海");
	}

}
