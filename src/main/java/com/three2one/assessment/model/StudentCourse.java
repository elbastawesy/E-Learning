package com.three2one.assessment.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "student_course")
public class StudentCourse extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Entity Student
     */
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @NotNull(message = "Student can not be empty")
    private Student student;

    /**
     * Entity Student
     */
    @ManyToOne
    @JoinColumn(name = "COURSE_ID", nullable = false)
    @NotNull(message = "Course can not be empty")
    private Course course;

    public StudentCourse() {
    }

    public StudentCourse(@NotNull(message = "Student can not be empty") Student student,
                         @NotNull(message = "Course can not be empty") Course course) {
        this.student = student;
        this.course = course;
    }


    @PrePersist
    public void validatePrePersist() {
        super.validatePrePersist();
    }

    @PreUpdate
    public void validatePreUpdate() {
        super.validatePreUpdate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
