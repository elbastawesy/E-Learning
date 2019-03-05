package com.three2one.assessment.service;

import com.three2one.assessment.model.Student;

import javax.xml.bind.ValidationException;


public interface StudentService {
    Student save(Student student) throws ValidationException;

    Student getById(Long studentId) throws Exception;
}
