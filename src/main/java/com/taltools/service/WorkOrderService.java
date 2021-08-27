package com.taltools.service;

import com.taltools.entity.WorkOrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkOrderService {
    List<WorkOrderEntity> getRsult(String wo_number);
}
