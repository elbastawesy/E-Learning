package com.three2one.assessment.service;

import com.three2one.assessment.model.Course;

import java.util.List;


public interface CourseService {
    Course save(Course course) throws Exception;

    Course getById(Long courseId) throws Exception;

    List<Course> getAvailableCourses(Long studentId, Long count) throws Exception;

    List<Course> getRegisteredCourses(Long studentId, Long count) throws Exception;
}
