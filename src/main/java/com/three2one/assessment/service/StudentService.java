package com.three2one.assessment.service;

import com.three2one.assessment.model.Student;


public interface StudentService {
    Student save(Student student) throws Exception;

    Student getById(Long studentId) throws Exception;
}
