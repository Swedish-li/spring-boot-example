package com.lrs.springboot.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = { RestController.class })
public class GlobalControllerAdvice {

	private final static Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);
	/** 默认时间格式 */
	private final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 统一异常处理
	 * 
	 * @param t
	 * @param req
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Void> throwableHandler(Throwable t, HttpServletRequest req) {
		logger.error("请求：" + req.getRequestURI() + " 发生异常！", t);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	/**
	 * 特殊格式数据绑定处理
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat(DEFAULT_DATE_FORMAT), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
}
