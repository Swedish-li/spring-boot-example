package com.lrs.springboot.common;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lrs.springboot.config.MailProperties;

/**
 * 如果Spring Boot在优先级更高的位置找到了配置，那么它就会无视优先级低的配置。
 * @author Swedish-li
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMail {
	@Resource
	private JavaMailSender mailSender;
	@Resource
	private MailProperties mailProperties;

	@Test
	public void testSendEmail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("#");
		// 此发件人必须和javaMailSender一致
		mailMessage.setFrom(mailProperties.getFrom());
		// 测试邮件主题
		mailMessage.setSubject("测试邮件（邮件主题）");
		// 测试邮件内容
		mailMessage.setText("这是邮件内容");

		mailSender.send(mailMessage);
	}
}
