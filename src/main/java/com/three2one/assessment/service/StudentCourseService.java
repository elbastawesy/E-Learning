package com.three2one.assessment.service;

import com.three2one.assessment.dto.StudentCourseDTO;
import com.three2one.assessment.model.StudentCourse;


public interface StudentCourseService {
    StudentCourse registerInCourse(StudentCourseDTO studentCourseDTO) throws Exception;

    void unRegisterFromCourse(StudentCourseDTO studentCourseDTO) throws Exception;
}
