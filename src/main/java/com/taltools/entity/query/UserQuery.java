package com.taltools.entity.query;


import lombok.Data;


@Data
public class UserQuery  {
    private Integer pageNum = 1;   // 当前的页码
    private Integer pageSize  = 10;   //每一页所显示的数量
    private String name;    // 根据用户查询
}
