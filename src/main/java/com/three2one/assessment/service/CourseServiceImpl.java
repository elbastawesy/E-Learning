package com.three2one.assessment.service;

import com.three2one.assessment.model.Course;
import com.three2one.assessment.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getById(Long courseId) {
        return courseRepository.getById(courseId);
    }

    @Override
    public List<Course> getAvailableCourses(Long studentId, Long count) {
        return courseRepository.getAvailableCourses(studentId, PageRequest.of(0, count.intValue()));
    }

    @Override
    public List<Course> getRegisteredCourses(Long studentId, Long count) {
        return courseRepository.getRegisteredCourses(studentId, PageRequest.of(0, count.intValue()));
    }
}
