package com.ouc.domin;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author dqs
 * @description 图书实体类
 * @create 2021/11/1 10:18
 */
@Data
public class Book {
    @TableId
    private Integer bookId;
    private String type;
    private String name;
    private String description;
}
