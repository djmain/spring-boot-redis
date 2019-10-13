package com.jay.spring.boot.redis;

import com.jay.spring.boot.redis.book.Book;
import com.jay.spring.boot.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootRedisApplicationTests
{

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void contextLoads()
    {
        redisUtil.set("name", "zhangming");
        Object name = redisUtil.get("name");
        System.out.println(name);
    }


    @Test
    public void get()
    {
        Object name = redisUtil.get("name");
    }


    @Test
    public void set()
    {
        Book book = new Book(2L, "Java并发编程的艺术", 99);
        redisUtil.set("book::" + book.getId(), book);
        Book book1 = (Book) redisUtil.get("book::" + book.getId());
        log.info("book1:{}", book1);
    }

}
