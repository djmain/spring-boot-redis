package com.jay.spring.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//启用缓存
@EnableCaching
public class SpringBootRedisApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

}
