package com.ouc.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ouc.domin.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dqs
 * @description Mapper层测试类
 * @dateTime 2021/11/1 10:38
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelectCount() {
        Long count = bookMapper.selectCount(null);
        System.out.println(count);
    }

    @Test
    void testGetPage() {
        IPage<Book> bookPage = new Page<>(1, 2);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();

        bookMapper.selectPage(bookPage, null);
        System.out.println(bookPage.getRecords());
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试类型");
        book.setDescription("测试描述");
        bookMapper.insert(book);
    }

    @Test
    void testSelectList() {
        String type = "null";

        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(type != null, Book::getType, "计算机");

        bookMapper.selectList(wrapper);
    }
}
