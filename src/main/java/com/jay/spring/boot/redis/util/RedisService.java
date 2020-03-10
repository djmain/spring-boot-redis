package com.jay.spring.boot.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * created by Jay on 2020/3/10
 */
@Service
@Slf4j
public class RedisService
{
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * scan 实现
     *
     * @param pattern  表达式
     * @param consumer 对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer)
    {
        this.stringRedisTemplate.execute((RedisConnection connection) -> {
//            connection.select(1);
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().match(pattern).count(Integer.MAX_VALUE).build()))
            {
                cursor.forEachRemaining(consumer);
                return null;
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
//            ScanOptions options = ScanOptions.scanOptions().match().count()
//            Cursor c = connection.scan(options);
//            while (c.hasNext())
//            {
//                String key = new String((byte[]) c.next());
//                log.info(key);
//            }
        });
    }

    /**
     * 获取符合条件的key
     *
     * @param pattern 表达式
     * @return
     */
    public List<String> keys(String pattern)
    {
        List<String> keys = new ArrayList<>();
        this.scan(pattern, item -> {
            //符合条件的key
            String key = new String(item, StandardCharsets.UTF_8);
            keys.add(key);
        });
        return keys;
    }

    public String randomKey()
    {
        return stringRedisTemplate.randomKey();
    }

}
