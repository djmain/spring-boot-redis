package com.jay.spring.boot.redis.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by Jay on 2019/10/1
 */
@RestController
public class BookController
{

    @Autowired
    BookService bookService;

    @GetMapping("book/{id}")
    public Book book(@PathVariable("id") Long id)
    {
        return bookService.book(id);
    }

    @GetMapping("getbook/{id}")
    public Book getBook(@PathVariable("id") Long id)
    {
        return bookService.getBook(id);
    }
}
