package com.three2one.assessment.service;

import com.three2one.assessment.model.Student;
import com.three2one.assessment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) throws Exception {
        student.setId(null);
        validateBusinessRule(student);
        return studentRepository.save(student);
    }


    private void validateBusinessRule(Student student) throws ValidationException {
        if (student.getId() == null) {
            boolean existsByUsername = studentRepository.existsByUsername(student.getUsername());
            if (existsByUsername) {
                throw new ValidationException("Username already exist");
            }
        }
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.getById(studentId);
    }
}
