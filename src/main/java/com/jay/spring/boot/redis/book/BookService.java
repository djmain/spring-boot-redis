package com.jay.spring.boot.redis.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * created by Jay on 2019/10/1
 */
@Service
@Slf4j
public class BookService
{
    @Autowired
    RedisTemplate redisTemplate;

    public Book book(Long id)
    {
        Book book = (Book) redisTemplate.opsForValue().get("book:" + id);
        if (book == null)
        {
            book = new Book(id, "Java编程思想", 99);
            redisTemplate.opsForValue().set("book:" + id, book);
        }
        return book;
    }

    @Cacheable(key = "{books:#id}", value = "book")
    public Book getBook(Long id)
    {
        log.info("未命中缓存, id:{}", id);
        return new Book(id, "Java编程思想", 99);
    }
}
