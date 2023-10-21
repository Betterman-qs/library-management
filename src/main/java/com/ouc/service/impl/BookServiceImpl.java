package com.ouc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ouc.domin.Book;
import com.ouc.mapper.BookMapper;
import com.ouc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dqs
 * @description 图书服务层实现类
 * @dateTime 2021/11/1 15:44
 */
@Service
public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Boolean save(Book book) {
        int flag = bookMapper.insert(book);
        return flag > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer bookId) {
        return bookMapper.deleteById(bookId) > 0;
    }

    @Override
    public Book getById(Integer bookId) {
        return bookMapper.selectById(bookId);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int current, int size) {
        Page<Book> bookPage = new Page<>(current, size);
        bookMapper.selectPage(bookPage, null);
        return bookPage;
    }
}
