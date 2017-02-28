package com.lrs.springboot.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;

import net.minidev.json.JSONArray;

@Configuration
public class WebMvcConfig {

	public JSONArray getJson() {
		return new JSONArray();
	}
}
