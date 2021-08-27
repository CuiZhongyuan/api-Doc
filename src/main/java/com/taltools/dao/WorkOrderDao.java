package com.taltools.dao;

import com.taltools.entity.WorkOrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderDao {
    List<WorkOrderEntity> getResult(String wo_number);
}
