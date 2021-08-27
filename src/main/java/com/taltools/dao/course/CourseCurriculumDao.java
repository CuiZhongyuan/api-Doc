package com.taltools.dao.course;


import com.taltools.entity.CourseCurriculumEntity;
import org.springframework.stereotype.Repository;


@SuppressWarnings("ALL")
@Repository
public interface CourseCurriculumDao {
    CourseCurriculumEntity getCurriculumId(String classId);
}
