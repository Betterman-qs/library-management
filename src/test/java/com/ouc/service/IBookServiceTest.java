package com.ouc.service;

import com.ouc.domin.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author dqs
 * @description IBook服务测试类
 * @dateTime 2021/11/3 14:16
 */
@SpringBootTest
public class IBookServiceTest {

    @Autowired
    private IBookService iBookService;

    @Test
    void testList() {
        List<Book> books = iBookService.list();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void test() {
        Object o = Array.newInstance(int.class, 3);
        Array.set(o,1,2);
        System.out.println(Arrays.toString((int[]) o));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("type-type");
        book.setName("name-name");
        book.setDescription("this is test description");

        iBookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setBookId(5);
        book.setType("type-type5");
        book.setName("name-name5");
        book.setDescription("this is test description5");

        iBookService.updateById(book);
    }
}
