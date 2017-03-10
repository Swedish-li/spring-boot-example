package com.lrs.springboot.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.lrs.springboot.config.MailProperties.Smtp;

/**
 * 参考文章：www.jianshu.com/p/df57fefe0ab7
 * 
 * @author Swedish-li
 *
 */
@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class MailConfig {
	@Resource
	private MailProperties mailProperties;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Smtp smtp = mailProperties.getSmtp();
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", smtp.getAuth());
		properties.setProperty("mail.smtp.starttls.enable", smtp.getStarttlsEnable());
		mailSender.setJavaMailProperties(properties);
		mailSender.setHost(mailProperties.getHost());
		mailSender.setPassword(mailProperties.getPassword());
		mailSender.setPort(mailProperties.getPort());
		mailSender.setUsername(mailProperties.getUsername());
		return mailSender;

	}
}
