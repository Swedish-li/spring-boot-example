package com.lrs.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.abel533.echarts.Option;

@RestController
@RequestMapping("echarts")
public class EchartsExampleController {
	public ResponseEntity<Option> bar1() {
		Option option = new Option();
		
		return ResponseEntity.ok(option);
	}
}
