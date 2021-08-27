package com.taltools.service.impl;

import com.taltools.dao.WorkOrderDao;
import com.taltools.entity.WorkOrderEntity;
import com.taltools.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Autowired
    private WorkOrderDao workOrderDao;
    @Override
    public List<WorkOrderEntity> getRsult(String wo_number) {
        return workOrderDao.getResult(wo_number);
    }
}
