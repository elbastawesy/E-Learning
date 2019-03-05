package com.three2one.assessment.repository;

import com.three2one.assessment.model.Course;
import com.three2one.assessment.model.Student;
import com.three2one.assessment.model.StudentCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {

    StudentCourse getByCourseAndStudent(Course course, Student student);
}
