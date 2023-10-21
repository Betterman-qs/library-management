package com.ouc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ouc.domin.Book;
import com.ouc.mapper.BookMapper;
import com.ouc.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dqs
 * @description TODO
 * @dateTime 2021/11/3 10:29
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements IBookService {

    private BookMapper bookMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size) {
        Page<Book> bookPage = new Page<>(current, size);
        return bookMapper.selectPage(bookPage, null);
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size, Book book) {
        Page<Book> bookPage = new Page<>(current, size);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();

        //组织动态查询条件
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        return bookMapper.selectPage(bookPage, lqw);
    }
}
