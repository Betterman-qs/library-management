package com.ouc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ouc.controller.utils.Result;
import com.ouc.domin.Book;
import com.ouc.domin.Sensor;
import com.ouc.domin.SensorInfo;
import com.ouc.domin.Test;
import com.ouc.service.IBookService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dqs
 * @description 图书管理表现层
 * @dateTime 2021/11/3 14:55
 *
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    private IBookService bookService;

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/test")
    public Integer test(@RequestParam("num1") Integer num1, @RequestBody Test test) {
        System.out.println(num1);
        System.out.println(test);
        return 1;
    }

    @GetMapping
    public Result getAll() {
        List<Book> list = bookService.list();
        return new Result(null != list, list);
    }

    @GetMapping("/page")
    public Result getPage(@RequestParam(defaultValue = "1") Integer currentPage,
                          @RequestParam(defaultValue = "3") Integer pageSize,
                          Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        log.info("分页总页码数：" + page.getPages());
        //如果当前页码值大于总页码值，则默认查询最后一页
        if (currentPage > page.getPages()) {
            currentPage = (int) page.getPages();
            page = bookService.getPage(currentPage, pageSize, book);
        }
        return new Result(null != page, page);
    }

    @GetMapping("/{bookId}")
    public Result getById(@PathVariable Integer bookId) {
        return new Result(true, bookService.getById(bookId));
    }

    @PostMapping
    public Result save(@RequestBody Book book) {

        return new Result(bookService.save(book), "已成功添加图书信息");
    }

    @DeleteMapping("/{bookId}")
    public Result delete(@PathVariable Integer bookId) {
        return new Result(bookService.removeById(bookId));
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(bookService.updateById(book));
    }
}
