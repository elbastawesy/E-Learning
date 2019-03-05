package com.three2one.assessment.service;

import com.three2one.assessment.dto.StudentCourseDTO;
import com.three2one.assessment.model.Course;
import com.three2one.assessment.model.Student;
import com.three2one.assessment.model.StudentCourse;
import com.three2one.assessment.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Override
    public StudentCourse registerInCourse(StudentCourseDTO studentCourseDTO) throws Exception {

        // ensure that student not registered in course before
        StudentCourse byCourseAndStudent = getByCourseAndStudent(studentCourseDTO);
        if (byCourseAndStudent != null) {
            throw new ValidationException("Student already registered in course");
        }
        StudentCourse studentCourse = getStudentCourse(studentCourseDTO);
        return studentCourseRepository.save(studentCourse);
    }

    private StudentCourse getStudentCourse(StudentCourseDTO studentCourseDTO) throws Exception {
        Course course = new Course();
        course.setId(studentCourseDTO.getCourseId());
        Student student = new Student();
        student.setId(studentCourseDTO.getStudentId());
        return new StudentCourse(student, course);
    }

    private StudentCourse getByCourseAndStudent(StudentCourseDTO studentCourseDTO) throws Exception {
        Course course = courseService.getById(studentCourseDTO.getCourseId());
        if (course == null) {
            throw new ValidationException("Course not found for id : " + studentCourseDTO.getCourseId());
        }
        Student student = studentService.getById(studentCourseDTO.getStudentId());
        if (student == null) {
            throw new ValidationException("Student not found for id : " + studentCourseDTO.getStudentId());
        }
        return studentCourseRepository.getByCourseAndStudent(course, student);
    }

    @Override
    public void unRegisterFromCourse(StudentCourseDTO studentCourseDTO) throws Exception {
        StudentCourse byCourseAndStudent = getByCourseAndStudent(studentCourseDTO);
        studentCourseRepository.delete(byCourseAndStudent);
    }
}
