package com.lrs.boot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private StringRedisTemplate template;

    @Override
    public void run(String... strings) throws Exception {
        ValueOperations<String,String> ops = this.template.opsForValue();

        String key = "boot.key";
        if (!this.template.hasKey(key)){
            ops.set(key,"com.lrs");

        }

        System.out.println("Found key " + key + ", value=" + ops.get(key));
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args).close();
    }
}
