package com.ouc.service;

import com.ouc.domin.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author dqs
 * @description TODO
 * @dateTime 2021/11/1 16:02
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testGetAll() {
        List<Book> books = bookService.getAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
