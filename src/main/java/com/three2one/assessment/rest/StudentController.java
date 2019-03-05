package com.three2one.assessment.rest;

import com.three2one.assessment.model.Student;
import com.three2one.assessment.service.StudentService;
import com.three2one.assessment.util.rest.ResourceConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = ResourceConstant.STUDENT_RESOURCE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(path = ResourceConstant.STUDENT_REGISTER)
    public Student registerStudent(@RequestBody Student student) throws Exception {
        return this.studentService.save(student);
    }
}
