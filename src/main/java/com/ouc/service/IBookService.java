package com.ouc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ouc.domin.Book;

/**
 * @author dqs
 * @description TODO
 * @dateTime 2021/11/3 10:27
 */
public interface IBookService extends IService<Book> {

    /**
     * 获取图书信息的指定分页的数据
     * @param current 指定的页码
     * @param size 每页的图书信息条数
     * @return 返回分页对象
     */
    IPage<Book> getPage(Integer current, Integer size);

    /**
     * 获取指定条件匹配的图书信息的分页数据
     * @param current 指定的页码
     * @param size 每页的图书信息条数
     * @param book 图书信息条件匹配
     * @return 返回分页对象
     */
    IPage<Book> getPage(Integer current, Integer size, Book book);
}
