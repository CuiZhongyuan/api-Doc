package com.taltools.common.web.controller;


import com.taltools.common.web.page.TableDataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/system/cpmList")
public class InterfaceCallCountController extends BaseController {

    /**
     * 根据create_time,接口 id 查询时间范围内调用该接口的上有服务,服务去重,总数累加.
     * 入参：fnameId&查询起止时间->查询字段：count_time
     *
     * @return*/
    @GetMapping("/getIdServiceNameTotal")
    public TableDataInfo getIdServiceNameTotal(Object o){
         //设置分页
        startPage();
        //获取一个list对象
        List<Object> serviceNameTotalList = new ArrayList<>();
        //响应请求分页数据
        return getDataTable(serviceNameTotalList);
    }

}
