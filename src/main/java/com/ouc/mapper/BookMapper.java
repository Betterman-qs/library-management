package com.ouc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ouc.domin.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dqs
 * @description TODO
 * @dateTime 2021/11/1 10:32
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
