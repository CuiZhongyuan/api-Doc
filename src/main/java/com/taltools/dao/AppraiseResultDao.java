package com.taltools.dao;


import com.taltools.entity.AppraiseResultEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@SuppressWarnings("ALL")
@Repository
public interface AppraiseResultDao {
    int getType(String wo_number);
    List<String> getStuCode(String stu_code);
    List<AppraiseResultEntity> getAll(String wo_number);
    String deleteStuCode(String stu_code);
}
