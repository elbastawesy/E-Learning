package com.three2one.assessment.repository;

import com.three2one.assessment.model.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query(nativeQuery = true, value = "select distinct course.* from course  course where course.id not in (select course_id from student_course  where student_id = :studentId )")
    List<Course> getAvailableCourses(@Param("studentId") Long studentId, Pageable pageable);


    @Query(value = "select student from StudentCourse studentCourse join studentCourse.student student where student.id = :studentId ")
    List<Course> getRegisteredCourses(@Param("studentId") Long userId, Pageable pageable);

    Course getById(Long courseId);
}
