package com.lrs.springboot.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.abel533.echarts.Option;
import com.lrs.springboot.model.User;
import com.lrs.springboot.service.EchartsExampleService;

/**
 * Echarts配置项手册：http://echarts.baidu.com/option.html
 * 
 * @author liruishi
 *
 */
@RestController
@RequestMapping("echarts")
public class EchartsExampleController {

	@Resource
	private EchartsExampleService servies;

	@RequestMapping("user")
	public ResponseEntity<User> getUser(@RequestParam("birth") Date birth) {
		User user = new User(1);

		System.out.println(birth);

		user.setBirth(birth);
		// user.setEmail("1123234@qq.com");
		user.setName("jack");
		return ResponseEntity.ok(user);
	}

	@RequestMapping("valid")
	public String valid(@Valid @ModelAttribute User user, BindingResult result) {
		System.out.println(result);
		if (result.hasErrors()) {
			return result.getFieldError().getDefaultMessage();
		}
		return result.toString();
	}

	@RequestMapping("bar1")
	public ResponseEntity<Option> bar1() {
		return ResponseEntity.ok(servies.getBar1());
	}

	// 柱状图动画延迟
	@RequestMapping("funnel")
	public ResponseEntity<Option> getFunnel() {
		return ResponseEntity.ok(servies.getFunnel());
	}
}
