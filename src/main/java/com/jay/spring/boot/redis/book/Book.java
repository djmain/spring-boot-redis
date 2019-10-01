package com.jay.spring.boot.redis.book;

import lombok.Data;

import java.io.Serializable;

/**
 * created by Jay on 2019/10/1
 */
@Data
public class Book implements Serializable
{
    private Long id;
    private String name;
    private int price;

    public Book(Long id, String name, int price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
