package com.taltools.controller;

import com.taltools.service.AppraiseResultService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author czy
 */
@RestController
@RequestMapping(value = "/api")
public class AppraiseResultController {

    @Autowired
    private AppraiseResultService appraiseResultService;
    /**
     * @param wo_number 工单号
     * */
    @GetMapping("/getAll")
    public String getAll(@Param("wo_number") String wo_number){
        return appraiseResultService.getAll(wo_number);
    }
    /**
     * @param reqJson 入参参数
     */
    @PostMapping("/deleteAppraiseLogStuCode")
    public String deleteStuCode(@RequestBody String reqJson){
        return appraiseResultService.appraiseLog(reqJson);
    }

}
