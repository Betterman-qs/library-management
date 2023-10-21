package com.ouc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ouc.domin.Book;

import java.util.List;

/**
 * @author dqs
 * @description 图书服务层接口
 * @dateTime 2021/11/1 15:43
 */
public interface BookService {

    /**
     * 保存一本图书的数据
     * @param book 图书对象
     * @return 保存成功返回true，失败返回false
     */
    Boolean save(Book book);

    /**
     * 更新一本图书的相关信息
     * @param book 要更新的图书信息对象
     * @return 更新成功返回true，失败返回false
     */
    Boolean update(Book book);

    /**
     * 根据图书编号删除这本图示
     * @param bookId 图书编号
     * @return 删除成功返回ture，失败返回false
     */
    Boolean delete(Integer bookId);

    /**
     * 通过图书编号获取一本图书的信息
     * @param bookId 指定的图书编号
     * @return 返回图书实体对象
     */
    Book getById(Integer bookId);

    /**
     * 获取所有的图书信息
     * @return 返回所有图书的对象列表
     */
    List<Book> getAll();

    /**
     * 获取指定页的图书信息
     * @param current 指定的分页数
     * @param size 每一页的数据条数
     * @return 返回分页对象
     */
    IPage<Book> getPage(int current, int size);
}
