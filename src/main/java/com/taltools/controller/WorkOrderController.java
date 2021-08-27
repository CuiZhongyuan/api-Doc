package com.taltools.controller;


import com.taltools.entity.WorkOrderEntity;
import com.taltools.service.WorkOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author czy
 */
@RestController
@RequestMapping(value = "/api")
public class WorkOrderController {
    @Autowired
    private WorkOrderService workOrderService;
    @GetMapping("/getWorkNun")
    public List<WorkOrderEntity> getResult(@Param("wo_number") String wo_number){
        return workOrderService.getRsult(wo_number);
    }
}
