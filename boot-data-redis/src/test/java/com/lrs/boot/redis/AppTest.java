package com.lrs.boot.redis;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.data.redis.RedisConnectionFailureException;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Rule
    public OutputCapture   outputCapture = new OutputCapture();

    @Test
    public void testApp(){

        try {
            App.main(new String[0]);
        } catch (Exception e) {
            if (!redisServerRuning(e)){
                return;
            }
        }

        String output = this.outputCapture.toString();

        assertThat(output).contains("Found key boot.key, value=com.lrs");
    }

    private boolean redisServerRuning(Throwable ex){
        System.out.println(ex.getMessage());
        if (ex instanceof RedisConnectionFailureException){
            return false;
        }

        return (ex.getCause() == null)|| redisServerRuning(ex);
    }
}