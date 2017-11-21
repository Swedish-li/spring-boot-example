package com.lrs.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@RestController
public class App extends SpringBootServletInitializer {

    @GetMapping("index")
    public String index(){
        return "Hello World!";
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return  builder.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
