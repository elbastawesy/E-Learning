package com.three2one.assessment.dto;

import com.three2one.assessment.model.StudentCourse;

import java.io.Serializable;

public class StudentCourseDTO implements Serializable {
    private long registerationId;
    private long studentId;

    private long courseId;

    public StudentCourseDTO() {
    }

    public StudentCourseDTO(StudentCourse studentCourse) {
        this(studentCourse.getId(), studentCourse.getStudent().getId(), studentCourse.getCourse().getId());
    }

    public StudentCourseDTO(long studentId, long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public StudentCourseDTO(long registerationId, long studentId, long courseId) {
        this.registerationId = registerationId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getRegisterationId() {
        return registerationId;
    }

    public void setRegisterationId(long registerationId) {
        this.registerationId = registerationId;
    }
}
