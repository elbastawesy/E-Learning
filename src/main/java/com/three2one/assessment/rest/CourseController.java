package com.three2one.assessment.rest;

import com.three2one.assessment.dto.StudentCourseDTO;
import com.three2one.assessment.model.Course;
import com.three2one.assessment.model.StudentCourse;
import com.three2one.assessment.service.CourseService;
import com.three2one.assessment.service.StudentCourseService;
import com.three2one.assessment.util.ResourceConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ResourceConstant.COURSE_RESOURCE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentCourseService studentCourseService;

    @PostMapping(path = ResourceConstant.COURSE_CREATE)
    public Course courseCreate(@RequestBody Course course) throws Exception {
        return this.courseService.save(course);
    }

    @GetMapping(path = ResourceConstant.AVAILABLE_COURSES)
    public List<Course> getAvailableCourses(@PathVariable(value = "studentId", required = true) Long studentId,
                                            @RequestParam(value = "max", defaultValue = "5") Long count) throws Exception {
        return courseService.getAvailableCourses(studentId, count);
    }

    @GetMapping(path = ResourceConstant.REGISTERED_COURSES)
    public List<Course> getRegisteredCourses(@PathVariable(value = "studentId", required = true) Long studentId,
                                             @RequestParam(value = "max", defaultValue = "5") Long count) throws Exception {
        return courseService.getRegisteredCourses(studentId, count);
    }

    @PostMapping(path = ResourceConstant.COURSE_REGISTER)
    public StudentCourseDTO registerInCourse(@RequestBody StudentCourseDTO studentCourseDTO) throws Exception {
        StudentCourse studentCourse = studentCourseService.registerInCourse(studentCourseDTO);
        return new StudentCourseDTO(studentCourse);
    }

    @PostMapping(path = ResourceConstant.COURSE_UNREGISTER)
    public ResponseEntity unRegisterFromCourse(@RequestBody StudentCourseDTO studentCourseDTO) throws Exception {
        studentCourseService.unRegisterFromCourse(studentCourseDTO);
        return ResponseEntity.ok().build();
    }
}
