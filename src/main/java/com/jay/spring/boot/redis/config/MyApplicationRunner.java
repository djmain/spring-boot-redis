package com.jay.spring.boot.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * created by Jay on 2019/10/1
 */
@Slf4j
@Component
public class MyApplicationRunner implements ApplicationRunner
{
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate   redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        log.info("app begin to start.name:"+stringRedisTemplate.opsForValue().get("name"));
        System.out.println(stringRedisTemplate);
        System.out.println(stringRedisTemplate.delete("name"));
    }
}
