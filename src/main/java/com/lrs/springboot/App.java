package com.lrs.springboot;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring boot 示例项目
 * 在使用Maven搭建时出现启动项目后立即关闭的现象，原因为使用Maven下载的Tomcat集成jar有问题,删除重新下载就可以了 在启动参数中添加
 * --debug 参数可以查看Spring boot的启动信息
 * 
 * http://www.network-science.de/ascii/
 * http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
 * 
 * slf4j log4j
 * logback关系详解和相关用法：http://www.cnblogs.com/Sinte-Beuve/p/5758971.html
 * 
 * @author Swedish-li
 *
 */
@Controller
@SpringBootApplication
public class App {
	@RequestMapping("/")
	public String index(ModelMap model) {
		model.put("currentDatetime", new Date());
		return "index";
	}

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
}
