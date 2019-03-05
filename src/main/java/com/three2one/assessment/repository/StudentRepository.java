package com.three2one.assessment.repository;

import com.three2one.assessment.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    boolean existsByUsername(String userName);

    Student getById(Long studentId);
}
